package com.laoshiren.hello.seata.provider.orderItem;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * ProjectName:     hello-seata
 * Package:         com.laoshiren.hello.seata.provider
 * ClassName:       ProviderOrderItemApplication
 * Author:          laoshiren
 * Git:             xiangdehua@pharmakeyring.com
 * Description:
 * Date:            2020/6/23 15:45
 * Version:         1.0.0
 */
@EnableTransactionManagement
@EnableDiscoveryClient
@SpringBootApplication
public class ProviderOrderItemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderOrderItemApplication.class, args);
    }

}
