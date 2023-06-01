package com.bmes.EStoreMIS.controllers;

import com.bmes.EStoreMIS.models.lookUps.TransactionType;
import com.bmes.EStoreMIS.services.TransactionTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transactionType")
public class TransactionTypeController {

    @Autowired
    TransactionTypeServices transactionTypeServices;

    @PostMapping("setTypes")
    public void setTransactionType(@RequestBody List<TransactionType> transactionType){
        transactionTypeServices.setTransactionType(transactionType);
    }

    @GetMapping("getType")
    public List<TransactionType> getTransactionType(){
        return transactionTypeServices.getTransactionType();

    }


}
