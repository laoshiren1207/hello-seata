package com.laoshiren.hello.seata.http.controller;

import com.laoshiren.hello.seata.http.api.OrderService;
import com.laoshiren.hello.seata.http.domain.TbOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProjectName:     hello-seata
 * Package:         com.laoshiren.hello.seata.http.controller
 * ClassName:       OrderController
 * Author:          laoshiren
 * Git:             xiangdehua@pharmakeyring.com
 * Description:
 * Date:            2020/7/3 13:41
 * Version:         1.0.0
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("order")
    public String  insertOrder(){
        TbOrder order =new TbOrder();
        order.setOrderId(2L);
        order.setUserId(2L);
        int i = orderService.insertOrder(order);
        return ""+i;
    }

}