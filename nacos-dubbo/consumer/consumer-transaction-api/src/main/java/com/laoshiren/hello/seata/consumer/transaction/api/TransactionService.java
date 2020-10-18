package com.laoshiren.hello.seata.consumer.transaction.api;

import com.laoshiren.hello.seata.provider.order.domain.TbOrder;
import com.laoshiren.hello.seata.provider.orderItem.domain.TbOrderItem;

/**
 * ProjectName:     hello-seata
 * Package:         com.laoshiren.hello.seata.consumer.transaction.api
 * ClassName:       TransactionService
 * Author:          laoshiren
 * Git:             xiangdehua@pharmakeyring.com
 * Description:
 * Date:            2020/6/24 10:50
 * Version:         1.0.0
 */
public interface TransactionService {

    void doTransaction(TbOrder tbOrder, TbOrderItem tbOrderItem) throws Exception  ;

}
