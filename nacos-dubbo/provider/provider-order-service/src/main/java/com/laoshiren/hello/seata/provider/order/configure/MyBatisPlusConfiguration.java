package com.laoshiren.hello.seata.provider.order.configure;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * ProjectName:     hello-seata
 * Package:         com.laoshiren.hello.seata.provider.orderItem.configure
 * ClassName:       MyBatisPlusConfiguration
 * Author:          laoshiren
 * Git:             xiangdehua@pharmakeyring.com
 * Description:
 * Date:            2020/6/23 16:55
 * Version:         1.0.0
 */
@Configuration
@MapperScan(basePackages = "com.laoshiren.hello.seata.provider.order.mapper")
public class MyBatisPlusConfiguration {
}
