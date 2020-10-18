
## `nacos-dubbo`

### 说明
`provider` 项目中只有2种类型的项目一种是`api`,还有一种是`service`
所谓`api`项目是项目只有接口和`domain`,没有实现。此项目会被该`api`的实现（`service`）和需要调用`service`的项目依赖。
`service`项目是实现`api`项目的项目一般是去操作数据库或者其他业务的项目。

`consumer` 项目也只有2种类型的项目一种是`api`,还有一种是`service`
和上面一样，`service`项目会去调用对应的`provider`的接口，使用的是`dubbo rpc`的通讯

`business` 项目是指业务层的代码项目，他会去依赖`consumer`的`api`项目。然后对外部提供`RESTFul`的接口

所以在这个项目中，先启动2个`provider`中的`service`，然后启动`consumer`的`service`，最后启动`business`项目。

### 准备
首先需要创建2个库，一个库存放`order`表，一个库存放`order_item`。
~~~sql 
CREATE TABLE tb_order (
    id BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    order_id BIGINT(20) NOT NULL, 
    user_id BIGINT(20) NOT NULL);
~~~
~~~sql 
CREATE TABLE tb_order_item (
    id BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    user_id BIGINT(20) NOT NULL, 
    order_id BIGINT(20) NOT NULL, 
    order_item_id BIGINT(20) NOT NULL);
~~~
除此之外，还需要在每个库里都创建一个`undo_log`
~~~sql 
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) NOT NULL,
  `context` varchar(128) NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  `ext` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
~~~

#### provider
主要增加了 `Seata` 依赖
~~~xml 
<dependency>
    <groupId>io.seata</groupId>
    <artifactId>seata-spring-boot-starter</artifactId>
    <version>1.0.0</version>
</dependency>
~~~
配置文件
~~~yaml 
spring
  alibaba:
      seata:
        # 自定义事务组名称 tx_group，需要与服务端一致
        tx-service-group: tx-group
~~~
配置类,具体看项目的`SeataConfiguration`
~~~java 
import io.seata.rm.datasource.DataSourceProxy;

@Configuration
public class SeataConfiguration {
    @Primary
    @Bean("dataSource")
    public DataSourceProxy dataSource(DataSource hikariDataSource) {
        return new DataSourceProxy(hikariDataSource);
    }

    @Bean
    public GlobalTransactionScanner globalTransactionScanner() {
        /**
         * applicationId：同服务名即可
         * txServiceGroup：自定义事务组名，需要与 Seata Server 配置一致
         */
        return new GlobalTransactionScanner("provider-order-item", "tx_group");
    }
}
~~~
一定要在启动类上加上`@EnableTransactionManagement`

#### transaction
这里删除去了 `mybatis mysql hikari` 的依赖。
配置类
~~~java 
import io.seata.spring.annotation.GlobalTransactionScanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeataConfiguration {

    @Bean
    public GlobalTransactionScanner globalTransactionScanner() {
        return new GlobalTransactionScanner("consumer-transaction", "tx_group");
    }
}
~~~

实现方法上加上注解`@GlobalTransactional`
~~~java 
@Service(version = "1.0.0")
public class TransactionServiceImpl implements TransactionService {

    @Reference(version = "1.0.0")
    private OrderService orderService;

    @Reference(version = "1.0.0")
    private OrderItemService orderItemService;

    @Override
    @GlobalTransactional
    public void doTransaction(TbOrder tbOrder, TbOrderItem tbOrderItem) throws Exception {
        System.out.println("transaction 开始全局事务，XID = " + RootContext.getXID());
        orderService.insert(tbOrder);
        orderItemService.insert(tbOrderItem);
        if (tbOrderItem.getOrderId() ==2L) {
            throw  new RuntimeException("Exception for seata");
        }
    }
}
~~~

#### business
这里就正常调用`consumer`
~~~java 
@RestController
@RequestMapping("/v1/transaction")
public class TransactionController {

    @Reference(version = "1.0.0")
    private TransactionService transactionService;

    @GetMapping("")
    public String doTransaction() throws Exception {
        TbOrder order = new TbOrder();
        order.setOrderId(1L);
        order.setUserId(1L);

        TbOrderItem orderItem = new TbOrderItem();
        orderItem.setUserId(1L);
        orderItem.setOrderId(2L);
        orderItem.setOrderItemId(1L);
        transactionService.doTransaction(order,orderItem);
        return "ok";
    }
}
~~~

接下来就是浏览器访问[测试 http://127.0.0.1:27010/v1/transaction](http://127.0.0.1:27010/v1/transaction)
再到`Seata`服务上看到回滚的日志，再查看数据库