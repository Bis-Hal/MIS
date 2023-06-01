package com.bmes.EStoreMIS.services;

import com.bmes.EStoreMIS.Repository.TransactionTypeRepository;
import com.bmes.EStoreMIS.models.lookUps.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionTypeServices {

    @Autowired
    TransactionTypeRepository transactionTypeRepository;
    public void setTransactionType(List<TransactionType> transactionType) {
        transactionTypeRepository.saveAll(transactionType);
    }

    public List<TransactionType> getTransactionType() {
        return transactionTypeRepository.findAll();
    }
}
