package com.laoshiren.hello.seata.http.configure;

import com.zaxxer.hikari.HikariDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import io.seata.spring.annotation.GlobalTransactionScanner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * ProjectName:     hello-seata
 * Package:         com.laoshiren.hello.seata.http.configure
 * ClassName:       SeataConfiguration
 * Author:          laoshiren
 * Git:             xiangdehua@pharmakeyring.com
 * Description:
 * Date:            2020/7/3 14:50
 * Version:         1.0.0
 */
@Configuration
public class SeataConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        return hikariDataSource;
    }

    @Primary
    @Bean("dataSource")
    public DataSourceProxy dataSource(DataSource hikariDataSource) {
        return new DataSourceProxy(hikariDataSource);
    }

    /**
     * applicationId：同服务名即可
     * txServiceGroup：自定义事务组名，需要与 Seata Server 配置一致
     */
    @Bean
    public GlobalTransactionScanner globalTransactionScanner() {

        return new GlobalTransactionScanner("service-order-item", "tx_group");
    }


}
