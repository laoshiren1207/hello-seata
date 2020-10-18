package com.laoshiren.hello.seata.provider.orderItem.api;

import com.laoshiren.hello.seata.provider.orderItem.domain.TbOrderItem;

/**
 * ProjectName:     hello-seata
 * Package:         com.laoshiren.hello.seata.provider.order.api
 * ClassName:       OrderService
 * Author:          laoshiren
 * Git:             xiangdehua@pharmakeyring.com
 * Description:
 * Date:            2020/6/23 15:52
 * Version:         1.0.0
 */
public interface OrderItemService {

    int insert(TbOrderItem orderItem);

}
