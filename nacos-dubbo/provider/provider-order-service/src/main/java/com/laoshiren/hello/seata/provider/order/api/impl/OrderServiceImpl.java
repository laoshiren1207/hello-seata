package com.laoshiren.hello.seata.provider.order.api.impl;

import com.laoshiren.hello.seata.provider.order.api.OrderService;
import com.laoshiren.hello.seata.provider.order.domain.TbOrder;
import com.laoshiren.hello.seata.provider.order.mapper.TbOrderMapper;
import io.seata.core.context.RootContext;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * ProjectName:     hello-seata
 * Package:         com.laoshiren.hello.seata.provider.order.api.impl
 * ClassName:       OrderServiceImpl
 * Author:          laoshiren
 * Git:             xiangdehua@pharmakeyring.com
 * Description:
 * Date:            2020/6/24 10:08
 * Version:         1.0.0
 */
@Service(version = "1.0.0")
public class OrderServiceImpl implements OrderService {

    @Resource
    private TbOrderMapper mapper;

    @Override
    public int insert(TbOrder tbOrder) {
        System.out.println(" order 全局事务 id ：" + RootContext.getXID());
        return mapper.insert(tbOrder);
    }
}
