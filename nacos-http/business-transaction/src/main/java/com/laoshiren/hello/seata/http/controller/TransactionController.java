package com.laoshiren.hello.seata.http.controller;


import com.laoshiren.hello.seata.http.api.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProjectName:     hello-seata
 * Package:         com.laoshiren.hello.seata.http.controller
 * ClassName:       TransactionController
 * Author:          laoshiren
 * Git:             xiangdehua@pharmakeyring.com
 * Description:
 * Date:            2020/7/3 14:23
 * Version:         1.0.0
 */
@RestController
public class TransactionController {

    @Autowired
    private TransactionService service;

    @GetMapping("/v1/transaction")
    public String  transaction(){
        return service.doTransaction();
    }


}
