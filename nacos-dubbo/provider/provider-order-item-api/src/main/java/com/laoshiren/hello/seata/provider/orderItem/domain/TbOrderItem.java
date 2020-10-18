package com.laoshiren.hello.seata.provider.orderItem.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * ProjectName:     hello-seata 
 * Package:         com.laoshiren.hello.seata.provider.order.domain
 * ClassName:       TbOrderItem
 * Author:          laoshiren
 * Git:             xiangdehua@pharmakeyring.com
 * Description:     ${description}  
 * Date:            2020/6/23 16:25
 * Version:         1.0.0
 */
@Data
@TableName(value = "tb_order_item")
public class TbOrderItem implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "user_id")
    private Long userId;

    @TableField(value = "order_id")
    private Long orderId;

    @TableField(value = "order_item_id")
    private Long orderItemId;

    private static final long serialVersionUID = 1L;
}