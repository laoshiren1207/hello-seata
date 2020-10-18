package com.laoshiren.hello.seata.business.transaction.service.controller;

import com.laoshiren.hello.seata.consumer.transaction.api.TransactionService;
import com.laoshiren.hello.seata.provider.order.domain.TbOrder;
import com.laoshiren.hello.seata.provider.orderItem.domain.TbOrderItem;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProjectName:     hello-seata
 * Package:         com.laoshiren.hello.seata.business.transaction.service.controller
 * ClassName:       TransactionController
 * Author:          laoshiren
 * Git:             xiangdehua@pharmakeyring.com
 * Description:
 * Date:            2020/6/24 13:15
 * Version:         1.0.0
 */
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
