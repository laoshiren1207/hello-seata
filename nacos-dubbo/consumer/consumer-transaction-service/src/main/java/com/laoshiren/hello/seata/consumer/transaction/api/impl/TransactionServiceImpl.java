package com.laoshiren.hello.seata.consumer.transaction.api.impl;

import com.laoshiren.hello.seata.consumer.transaction.api.TransactionService;
import com.laoshiren.hello.seata.provider.order.api.OrderService;
import com.laoshiren.hello.seata.provider.order.domain.TbOrder;
import com.laoshiren.hello.seata.provider.orderItem.api.OrderItemService;
import com.laoshiren.hello.seata.provider.orderItem.domain.TbOrderItem;
import io.seata.core.context.RootContext;
import io.seata.core.exception.TransactionException;
import io.seata.spring.annotation.GlobalTransactional;
import io.seata.tm.api.GlobalTransactionContext;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ProjectName:     hello-seata
 * Package:         com.laoshiren.hello.seata.consumer.transaction.api.impl
 * ClassName:       TransactionServiceImpl
 * Author:          laoshiren
 * Git:             xiangdehua@pharmakeyring.com
 * Description:
 * Date:            2020/6/24 11:18
 * Version:         1.0.0
 */

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
