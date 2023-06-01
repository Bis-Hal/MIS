package com.bmes.EStoreMIS.controllers;

import com.bmes.EStoreMIS.models.lookUps.Finance;
import com.bmes.EStoreMIS.services.FinanceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("finances")
public class FinanceController {

    @Autowired
    private FinanceServices financeServices;

    @PostMapping("setFinance")
    public void setFinance(@RequestBody Finance finance){
        financeServices.setFinance(finance);
    }
    @PostMapping("setAllFinances")
    public void setAllFinances(@RequestBody List<Finance> finance){
        financeServices.setAllFinances(finance);
    }

    @GetMapping("getAllFinances")
    public List<Finance> getAllFinances(){
        return financeServices.getAllFinances();
    }
}
