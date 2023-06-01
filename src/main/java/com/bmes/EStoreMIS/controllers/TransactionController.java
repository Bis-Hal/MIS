package com.bmes.EStoreMIS.controllers;

import com.bmes.EStoreMIS.services.TransactionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("transactions")
public class TransactionController {

    @Autowired
    private TransactionServices transactionServices;

    @GetMapping("getTotalBudget")
    public List<Long> getTotalBudget(){
        return transactionServices.totalBudget();
    }
}
