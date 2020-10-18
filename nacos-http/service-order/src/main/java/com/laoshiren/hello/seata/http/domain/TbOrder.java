package com.laoshiren.hello.seata.http.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * ProjectName:     hello-seata 
 * Package:         com.laoshiren.hello.seata.http.domain
 * ClassName:       TbOrder
 * Author:          laoshiren
 * Git:             xiangdehua@pharmakeyring.com
 * Description:     ${description}  
 * Date:            2020/7/3 13:18
 * Version:         1.0.0
 */
@Data
@TableName(value = "tb_order")
public class TbOrder implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "order_id")
    private Long orderId;

    @TableField(value = "user_id")
    private Long userId;

    private static final long serialVersionUID = 1L;
}