package com.laoshiren.hello.seata.provider.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * ProjectName:     hello-seata
 * Package:         com.laoshiren.hello.seata.provider.order
 * ClassName:       ProviderOrderApplication
 * Author:          laoshiren
 * Git:             xiangdehua@pharmakeyring.com
 * Description:
 * Date:            2020/6/24 9:51
 * Version:         1.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement
public class ProviderOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderOrderApplication.class, args);
    }

}