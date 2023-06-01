package com.bmes.EStoreMIS.services;

import com.bmes.EStoreMIS.Repository.FinanceRepository;
import com.bmes.EStoreMIS.Repository.TransactionTypeRepository;
import com.bmes.EStoreMIS.Repository.TransactionsRepository;
import com.bmes.EStoreMIS.models.Time;
import com.bmes.EStoreMIS.models.Transactions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@SpringBootTest
class TransactionServicesTest {
    @Autowired
    TransactionsRepository transactionsRepository;
    @Autowired
    FinanceRepository financeRepository;

    @Autowired
    TransactionTypeRepository transactionTypeRepository;

    @Test
    void setTransactionsRepository() {
        long x = transactionsRepository.sumAmountByTransactionTypeId(UUID.fromString("1d03065f-3f73-4818-ac70-b973e3d0a986"));
           long y = transactionsRepository.sumAmountByTransactionTypeId(UUID.fromString( "dbd866f9-0e30-41b0-9293-28807caaac83"));
        System.out.println(x);
        System.out.println(y);
    }

    @Test
    void setTran() {
        for (int i : new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}) {


            Time time = Time.builder()
                    .month(LocalDate.now().getMonthValue())
                    .days(LocalDate.now().getDayOfMonth())
                    .year(LocalDate.now().getYear())
                    .time(LocalTime.now())
                    .build();
            Transactions transactions = Transactions.builder()
                    .financeId(financeRepository.findByFinance("Khalti").getFinanceId())
                    .discount(0)
                    .amount(40_000L)
                    .total(40_000L)
                    .time(time)
                    .transactionTypeId(transactionTypeRepository.findByType("Received").getTypeId())
                    .build();
            transactionsRepository.save(transactions);
        }
    }

}