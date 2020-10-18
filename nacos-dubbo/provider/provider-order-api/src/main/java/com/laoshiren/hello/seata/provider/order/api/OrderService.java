package com.laoshiren.hello.seata.provider.order.api;

import com.laoshiren.hello.seata.provider.order.domain.TbOrder;

/**
 * ProjectName:     hello-seata
 * Package:         com.laoshiren.hello.seata.provider.order.api
 * ClassName:       OrderService
 * Author:          laoshiren
 * Git:             xiangdehua@pharmakeyring.com
 * Description:
 * Date:            2020/6/23 16:31
 * Version:         1.0.0
 */
public interface OrderService {

    int insert(TbOrder tbOrder);

}
