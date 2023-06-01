package com.bmes.EStoreMIS.services;

import com.bmes.EStoreMIS.Repository.SuppliesRepository;
import com.bmes.EStoreMIS.dao.SuppliesDao;
import com.bmes.EStoreMIS.DTO.BarChart;
import com.bmes.EStoreMIS.models.Products;
import com.bmes.EStoreMIS.models.Supplies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SuppliesServices {

    @Autowired
    private SuppliesRepository suppliesRepository;

    @Autowired
    private SuppliesDao suppliesDao;

    public List<Supplies> getSupplies() {
        return suppliesRepository.findAll();
    }

    public void setSupply(Supplies supplies) {
        suppliesRepository.save(supplies);
    }


    public void setSupplies(List<Supplies> supplies) {
        suppliesRepository.saveAll(supplies);
    }

    public List<BarChart> getTotalQuantityByEachMonthAndYear(int year){
        List<BarChart> barCharts = new ArrayList<>();
        List<BarChart.Bar> bars = new ArrayList<>();

        for (int months =1; months<13;months++){
            bars.add(new BarChart.Bar(months,suppliesDao.getTotalQuantityByEachMonthAndYear(year, months)));
        }
        barCharts.add(BarChart.builder().barEntriesMonths(bars).year(year).build());
        return barCharts;
    }

    public void getSuppliesInfo(){
        suppliesRepository.findAll().forEach(
                supplies -> {
                    Products products = supplies.getProducts();
                }
        );

        suppliesDao.getSuppliesInfo().forEach(System.out::println);
    }
}
