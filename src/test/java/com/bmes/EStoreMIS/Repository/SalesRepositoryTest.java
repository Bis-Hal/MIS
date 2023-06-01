package com.bmes.EStoreMIS.Repository;

import com.bmes.EStoreMIS.DTO.BarChart;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SalesRepositoryTest {
    @Autowired
    SalesRepository salesRepository;
    private final int[] months = {1,2,3,4,5,6,7,8,9,10,11,12};

    @Test
    void findQuantityByYearAndMonth() {
        List<BarChart> barCharts = new ArrayList<>();

//
//        int fromYear = 2020;
//        int toYear = 2022;
//         for (int year=fromYear; year<=toYear;year++){
//             int currentYear = year;
//             List<BarChart.Bar> entries = new ArrayList<>();
//             Arrays.stream(months).forEach(value -> {
//                 List<Sales> sales = salesRepository.findQuantityByTimeYearAndTimeMonth(currentYear,value);
//                 sales.forEach(sales1 -> {
//                     if(sales1 != null){
//                         entries.add(new BarChart.Bar(sales1.getTime().getMonth(),sales1.getQuantity()));
//                     }
//                 });
//             });
//
//             barCharts.add(BarChart.builder()
//                     .year(currentYear)
//                     .barEntriesMonths(entries)
//                     .build());
//         }
//
//         barCharts.forEach(barChart -> {
//             System.out.println(barChart.getYear());
//             barChart.getBarEntriesMonths().forEach(bar -> {
//                 System.out.println(bar.getMonth());
//                 System.out.println(bar.getQuantity());
//             });
//         });


    }
}