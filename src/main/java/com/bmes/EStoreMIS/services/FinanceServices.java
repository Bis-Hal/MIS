package com.bmes.EStoreMIS.services;

import com.bmes.EStoreMIS.Repository.FinanceRepository;
import com.bmes.EStoreMIS.models.lookUps.Finance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanceServices {

    @Autowired
    private FinanceRepository financeRepository;

    public void setFinance(Finance finance) {
        financeRepository.save(finance);
    }

    public List<Finance> getAllFinances() {
        return financeRepository.findAll();
    }

    public void setAllFinances(List<Finance> finance) {
        financeRepository.saveAll(finance);
    }
}
