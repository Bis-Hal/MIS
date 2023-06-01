package com.bmes.EStoreMIS.controllers;

import com.bmes.EStoreMIS.DTO.BarChart;
import com.bmes.EStoreMIS.DTO.PieValues;
import com.bmes.EStoreMIS.models.Customers;
import com.bmes.EStoreMIS.services.CustomersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomersController {

    private final CustomersServices customersServices;

    @Autowired
    public CustomersController(CustomersServices customersServices) {
        this.customersServices = customersServices;
    }

    @PostMapping("setCustomer")
    public void setCustomer(@RequestBody Customers customer) {
        customersServices.setCustomer(customer);
    }

    @GetMapping("getAllCustomers")
    public List<Customers> getAllCustomers() {
        return customersServices.getAllCustomers();
    }

    @GetMapping("getAllTargetMarket")
    public List<PieValues> getTargetMarketByGender() {

        return customersServices.getTargetMarket();
    }

    @GetMapping("getTargetMarketByAge")
    public PieValues getTargetMarketByAge(){
            return customersServices.getTargetMarketByAge();
    }


    @GetMapping("getCustomerCountByYear/{year}")
    public List<BarChart> getCustomerCountByYear(@PathVariable("year") int year){
        return customersServices.getCustomerCountByYear(year);
    }

    @GetMapping("con")
    public List<HashMap<String, String>> getConnection(){
        List<HashMap<String, String>> list = new ArrayList<>();
        for(int i = 0; i<4000; i ++){
            HashMap<String, String> name1 = new HashMap<>();
            name1.put("name","Bishal");

            list.add(name1);
        }

        return list;
    }

}
