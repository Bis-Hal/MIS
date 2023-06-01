package com.bmes.EStoreMIS.services;

import com.bmes.EStoreMIS.Repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionServices {

    @Autowired
    private TransactionsRepository transactionsRepository;

    public List<Long> totalBudget(){
        long x = transactionsRepository.sumAmountByTransactionTypeId(UUID.fromString("1d03065f-3f73-4818-ac70-b973e3d0a986"));
        long y = transactionsRepository.sumAmountByTransactionTypeId(UUID.fromString( "dbd866f9-0e30-41b0-9293-28807caaac83"));
        return List.of(x,y);
    }

}
