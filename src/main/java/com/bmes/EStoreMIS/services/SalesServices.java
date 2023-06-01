package com.bmes.EStoreMIS.services;

import com.bmes.EStoreMIS.Repository.SalesRepository;
import com.bmes.EStoreMIS.dao.SalesDao;
import com.bmes.EStoreMIS.DTO.BarChart;
import com.bmes.EStoreMIS.models.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class SalesServices {
    @Autowired
    private SalesRepository salesRepository;
    @Autowired
    private SalesDao salesDao;

    public void setAllSales(List<Sales> sales) {
        salesRepository.saveAll(sales);
    }

    public void setSale(Sales sales) {
        salesRepository.save(sales);
    }

    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    public List<BarChart> getSalesDataByFromYearToYear(int fromYear, int toYear) {
        List<BarChart> barCharts = new ArrayList<>();

        for (int year = fromYear; year <= toYear; year++) {
            List<BarChart.Bar> entries = new ArrayList<>();

            salesDao.getSalesDataByFromYearToYear(year).forEach(sales -> {
                if (sales != null) {
                    entries.add(BarChart.Bar.builder().month(sales.getTime().getMonth()).quantity(sales.getQuantity()).build());
                }

            });
            if (!entries.isEmpty()) {
                if (fromYear == toYear) {
                    barCharts.add(setIndicator(fromYear, entries));
                }
                else {
                    barCharts.add(BarChart.builder()
                            .year(year)
                            .barEntriesMonths(entries)
                            .build());
                }


            }


        }

        return barCharts;
    }

    public BarChart setIndicator(int currentYear, List<BarChart.Bar> entries) {
        AtomicLong currentYearTotal = new AtomicLong(0);
        AtomicLong previousYearTotal = new AtomicLong(2000);

        int previousYear = currentYear - 1;

        salesRepository.sumQuantity(currentYear).ifPresent(currentYearTotal::set);
        salesRepository.sumQuantity(previousYear).ifPresent(previousYearTotal::set);

        double change = currentYearTotal.longValue() - previousYearTotal.longValue();
        double previous = previousYearTotal.longValue() != 0 ? previousYearTotal.longValue() : 1L;

        int value = change > 0 ? 1 : -1;
        int arrow = change == 0 ? 0 : value;

        double indicator = Math.abs(((change) / previous) * 100);
        return BarChart.builder()
                .indicator(indicator)
                .arrow(arrow)
                .previous(previousYearTotal.longValue())
                .year(currentYear)
                .barEntriesMonths(entries)
                .current(currentYearTotal.longValue())
                .build();
    }

}
