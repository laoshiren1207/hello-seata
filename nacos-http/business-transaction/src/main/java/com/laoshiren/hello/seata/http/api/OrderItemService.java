package com.laoshiren.hello.seata.http.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * ProjectName:     hello-seata
 * Package:         com.laoshiren.hello.seata.http.api
 * ClassName:       OrderItemService
 * Author:          laoshiren
 * Git:             xiangdehua@pharmakeyring.com
 * Description:
 * Date:            2020/7/3 14:24
 * Version:         1.0.0
 */
@FeignClient(value = "service-order-item")
public interface OrderItemService {

    @PostMapping("orderItem")
    String insertOrderItem();

}
