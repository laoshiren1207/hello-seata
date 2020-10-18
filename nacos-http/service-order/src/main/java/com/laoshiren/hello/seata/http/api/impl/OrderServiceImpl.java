package com.laoshiren.hello.seata.http.api.impl;

import com.laoshiren.hello.seata.http.api.OrderService;
import com.laoshiren.hello.seata.http.domain.TbOrder;
import com.laoshiren.hello.seata.http.mapper.TbOrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ProjectName:     hello-seata
 * Package:         com.laoshiren.hello.seata.http.api.impl
 * ClassName:       OrderServiceImpl
 * Author:          laoshiren
 * Git:             xiangdehua@pharmakeyring.com
 * Description:
 * Date:            2020/7/3 13:40
 * Version:         1.0.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private TbOrderMapper orderMapper;

    @Override
    public int insertOrder(TbOrder order) {
        return orderMapper.insert(order);
    }
}
