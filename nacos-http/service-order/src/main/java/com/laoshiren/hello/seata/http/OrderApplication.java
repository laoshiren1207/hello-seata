package com.laoshiren.hello.seata.http;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ProjectName:     hello-seata
 * Package:         com.laoshiren.hello.seata.http
 * ClassName:       BusinessTransactionApplication
 * Author:          laoshiren
 * Git:             xiangdehua@pharmakeyring.com
 * Description:
 * Date:            2020/7/3 13:12
 * Version:         1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.laoshiren.hello.seata.http.mapper")
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }

}