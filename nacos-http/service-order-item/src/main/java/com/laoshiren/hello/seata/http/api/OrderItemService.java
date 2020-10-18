package com.laoshiren.hello.seata.http.api;

import com.laoshiren.hello.seata.http.domain.TbOrderItem;

/**
 * ProjectName:     hello-seata
 * Package:         com.laoshiren.hello.seata.http.api
 * ClassName:       OrderItemService
 * Author:          laoshiren
 * Git:             xiangdehua@pharmakeyring.com
 * Description:
 * Date:            2020/7/3 14:09
 * Version:         1.0.0
 */
public interface OrderItemService {

    int insertOrderItem(TbOrderItem tbOrderItem);

}
