package com.laoshiren.hello.seata.http.api.impl;

import com.laoshiren.hello.seata.http.api.OrderItemService;
import com.laoshiren.hello.seata.http.api.OrderService;
import com.laoshiren.hello.seata.http.api.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProjectName:     hello-seata
 * Package:         com.laoshiren.hello.seata.http.api.impl
 * ClassName:       TransactionServiceImpl
 * Author:          laoshiren
 * Git:             xiangdehua@pharmakeyring.com
 * Description:
 * Date:            2020/7/3 14:35
 * Version:         1.0.0
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderItemService orderItemService;

    @Override
    public String doTransaction() {
        orderService.insertOrder();
        orderItemService.insertOrderItem();

        if (Math.random() > 0.5d) {
            throw new RuntimeException("Exception for seata");
        }

        return "ok";
    }
}
