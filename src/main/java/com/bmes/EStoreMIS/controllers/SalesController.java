package com.bmes.EStoreMIS.controllers;

import com.bmes.EStoreMIS.DTO.BarChart;
import com.bmes.EStoreMIS.models.Sales;
import com.bmes.EStoreMIS.services.SalesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sales")
public class SalesController {

    @Autowired
    private SalesServices salesServices;

    @PostMapping("setAllSales")
    public void setAllSales(@RequestBody List<Sales> sales) {
        salesServices.setAllSales(sales);
    }
    @PostMapping("setSale")
    public void setSale(@RequestBody Sales sales) {
        salesServices.setSale(sales);
    }

    @GetMapping("getAllSales")
    public List<Sales> getAllCustomers() {
        return salesServices.getAllSales();
    }

    @GetMapping("getSalesDataByFromYearToYear/{fromYear}/{toYear}")
    public List<BarChart> getSalesDataByFromYearToYear(@PathVariable("fromYear") int fromYear, @PathVariable("toYear") int toYear){
        return salesServices.getSalesDataByFromYearToYear(fromYear, toYear);
    }


}
