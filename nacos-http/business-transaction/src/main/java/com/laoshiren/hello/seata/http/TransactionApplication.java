package com.laoshiren.hello.seata.http;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ProjectName:     hello-seata
 * Package:         com.laoshiren.hello.seata.http
 * ClassName:       TransactionApplication
 * Author:          laoshiren
 * Git:             xiangdehua@pharmakeyring.com
 * Description:
 * Date:            2020/7/3 14:17
 * Version:         1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class TransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionApplication.class,args);
    }

}
