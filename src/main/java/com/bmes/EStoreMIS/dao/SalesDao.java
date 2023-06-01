package com.bmes.EStoreMIS.dao;

import com.bmes.EStoreMIS.Repository.SalesRepository;
import com.bmes.EStoreMIS.models.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SalesDao {
    @Autowired
    SalesRepository salesRepository;
    private final int[] months = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};


    public List<Sales> getSalesDataByFromYearToYear(int currentYear) {

            List<Sales> sales= salesRepository.findByTimeYear(currentYear);
            sales.forEach(sales1 -> {
                System.out.println(sales1.getTime().getMonth());
            });
            return sales;


    }
}
