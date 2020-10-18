package com.laoshiren.hello.seata.http.api.impl;

import com.laoshiren.hello.seata.http.api.OrderItemService;
import com.laoshiren.hello.seata.http.domain.TbOrderItem;
import com.laoshiren.hello.seata.http.mapper.TbOrderItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProjectName:     hello-seata
 * Package:         com.laoshiren.hello.seata.http.api.impl
 * ClassName:       OrderItemServiceImpl
 * Author:          laoshiren
 * Git:             xiangdehua@pharmakeyring.com
 * Description:
 * Date:            2020/7/3 14:27
 * Version:         1.0.0
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private TbOrderItemMapper tbOrderItemMapper;

    @Override
    public int insertOrderItem(TbOrderItem tbOrderItem) {
        return tbOrderItemMapper.insert(tbOrderItem);
    }
}
