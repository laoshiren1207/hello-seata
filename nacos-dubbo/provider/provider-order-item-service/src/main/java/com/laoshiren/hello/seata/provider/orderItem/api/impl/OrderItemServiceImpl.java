package com.laoshiren.hello.seata.provider.orderItem.api.impl;

import com.laoshiren.hello.seata.provider.orderItem.api.OrderItemService;
import com.laoshiren.hello.seata.provider.orderItem.domain.TbOrderItem;
import com.laoshiren.hello.seata.provider.orderItem.mapper.TbOrderItemMapper;
import io.seata.core.context.RootContext;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * ProjectName:     hello-seata
 * Package:         com.laoshiren.hello.seata.provider.order.api.impl
 * ClassName:       OrderItemServiceImpl
 * Author:          laoshiren
 * Git:             xiangdehua@pharmakeyring.com
 * Description:
 * Date:            2020/6/23 15:57
 * Version:         1.0.0
 */
@Service(version = "1.0.0")
public class OrderItemServiceImpl implements OrderItemService {

    @Resource
    private TbOrderItemMapper mapper;

    @Override
    public int insert(TbOrderItem orderItem) {
        System.out.println(" orderItem 全局事务 id ：" + RootContext.getXID());
        return mapper.insert(orderItem);
    }

}
