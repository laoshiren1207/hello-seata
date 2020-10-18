package com.laoshiren.hello.seata.http.controller;

import com.laoshiren.hello.seata.http.api.OrderItemService;
import com.laoshiren.hello.seata.http.domain.TbOrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProjectName:     hello-seata
 * Package:         com.laoshiren.hello.seata.http.controller
 * ClassName:       OrderItemController
 * Author:          laoshiren
 * Git:             xiangdehua@pharmakeyring.com
 * Description:
 * Date:            2020/7/3 14:29
 * Version:         1.0.0
 */
@RestController
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("orderItem")
    public String insertOrderItem(){
        TbOrderItem tbOrderItem = new TbOrderItem();
        tbOrderItem.setOrderId(2L);
        tbOrderItem.setUserId(2L);
        tbOrderItem.setOrderItemId(2L);
        int i = orderItemService.insertOrderItem(tbOrderItem);
        return ""+i;
    }


}
