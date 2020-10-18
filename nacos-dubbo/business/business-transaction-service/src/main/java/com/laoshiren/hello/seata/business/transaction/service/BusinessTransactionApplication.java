package com.laoshiren.hello.seata.business.transaction.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ProjectName:     hello-seata
 * Package:         com.laoshiren.hello.seata.business.transaction.service
 * ClassName:       BusinessTransactionApplication
 * Author:          laoshiren
 * Git:             xiangdehua@pharmakeyring.com
 * Description:
 * Date:            2020/6/24 13:13
 * Version:         1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class BusinessTransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessTransactionApplication.class,args);
    }

}
