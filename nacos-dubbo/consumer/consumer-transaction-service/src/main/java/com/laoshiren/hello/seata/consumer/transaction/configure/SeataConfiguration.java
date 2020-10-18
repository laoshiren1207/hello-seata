package com.laoshiren.hello.seata.consumer.transaction.configure;

import io.seata.spring.annotation.GlobalTransactionScanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ProjectName:     hello-seata
 * Package:         com.laoshiren.hello.seata.consumer.transaction.configure
 * ClassName:       SeataConfiguration
 * Author:          laoshiren
 * Git:             xiangdehua@pharmakeyring.com
 * Description:
 * Date:            2020/6/24 11:34
 * Version:         1.0.0
 */
@Configuration
public class SeataConfiguration {

    @Bean
    public GlobalTransactionScanner globalTransactionScanner() {
        return new GlobalTransactionScanner("consumer-transaction", "tx_group");
    }
}
