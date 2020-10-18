package com.laoshiren.hello.seata.consumer.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ProjectName:     hello-seata
 * Package:         com.laoshiren.hello.seata.consumer.transaction
 * ClassName:       TransactionApplication
 * Author:          laoshiren
 * Git:             xiangdehua@pharmakeyring.com
 * Description:     com.laoshiren.hello.seata.consumer.transaction.TransactionApplication
 * Date:            2020/6/24 10:55
 * Version:         1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerTransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerTransactionApplication.class, args);
    }

}