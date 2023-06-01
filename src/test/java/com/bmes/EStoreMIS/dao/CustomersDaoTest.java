package com.bmes.EStoreMIS.dao;

import com.bmes.EStoreMIS.DTO.BarChart;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class CustomersDaoTest {

    @Autowired
    CustomersDao customersDao;
    @Test
    void getCustomerDataByMonthAndYear() {
        List<BarChart> barCharts = new ArrayList<>();
        List<BarChart.Bar> bars = new ArrayList<>();

        for(int month = 1;month<13;month++){

            bars.add(new BarChart.Bar(month,customersDao.getCustomerCountByYear(month, 2023)));
        }
        barCharts.add(BarChart.builder()
                .year(2023)
                .barEntriesMonths(bars)
                .build());

        barCharts.forEach(barChart -> {
            barChart.getBarEntriesMonths().forEach(System.out::println);
        });

    }
}