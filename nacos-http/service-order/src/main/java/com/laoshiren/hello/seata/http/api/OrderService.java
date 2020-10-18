package com.laoshiren.hello.seata.http.api;

import com.laoshiren.hello.seata.http.domain.TbOrder;

/**
 * ProjectName:     hello-seata
 * Package:         com.laoshiren.hello.seata.http.api
 * ClassName:       OrderService
 * Author:          laoshiren
 * Git:             xiangdehua@pharmakeyring.com
 * Description:
 * Date:            2020/7/3 13:39
 * Version:         1.0.0
 */
public interface OrderService {

    int insertOrder(TbOrder order);

}
