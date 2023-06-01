package com.bmes.EStoreMIS.services;

import com.bmes.EStoreMIS.Repository.CustomersRepository;
import com.bmes.EStoreMIS.dao.CustomersDao;
import com.bmes.EStoreMIS.DTO.BarChart;
import com.bmes.EStoreMIS.DTO.PieValues;
import com.bmes.EStoreMIS.models.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomersServices {

    private final CustomersRepository customersRepository;

    @Autowired
    private CustomersDao customersDao;

    @Autowired
    public CustomersServices(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    public void setCustomer(Customers customer) {
        System.out.println(customersRepository.save(customer));
    }

    public List<Customers> getAllCustomers() {
        return customersRepository.findAll();
    }

    public List<PieValues> getTargetMarket() {
        return customersDao.getTargetMarket();
    }

    public PieValues getTargetMarketByAge() {
        float total = customersRepository.findAll().size();
        List<PieValues.PieEntry> calculatedValue = new ArrayList<>();

        customersDao.getTargetMarketByAge().forEach((label,age) -> {
            calculatedValue.add(new PieValues.PieEntry((age / total) * 100,label));
        });

        return PieValues.builder()
                .title("Age")
                .pieEntries(calculatedValue)
                .build();


    }

    public List<BarChart> getCustomerCountByYear(int year){
        List<BarChart> barCharts = new ArrayList<>();
        List<BarChart.Bar> bars = new ArrayList<>();

        for(int month = 1;month<13;month++){
            bars.add(new BarChart.Bar(month,customersDao.getCustomerCountByYear(month, year)));
        }
        barCharts.add(BarChart.builder()
                .year(year)
                .barEntriesMonths(bars)
                .build());

       return barCharts;
    }


}
