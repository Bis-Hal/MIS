package com.bmes.EStoreMIS.controllers;

import com.bmes.EStoreMIS.DTO.BarChart;
import com.bmes.EStoreMIS.models.Supplies;
import com.bmes.EStoreMIS.services.SuppliesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("supplies")
public class SuppliesController {

    @Autowired
    private SuppliesServices suppliesServices;

    @PostMapping("setSupplies")
    public void setSupplies(@RequestBody List<Supplies> supplies){
        suppliesServices.setSupplies(supplies);
    }

    @PostMapping("setSupply")
    public void setSupply(@RequestBody Supplies supplies){
        suppliesServices.setSupply(supplies);
    }

    @GetMapping("getSupplies")
    public List<Supplies> setSupplies(){
        return suppliesServices.getSupplies();
    }

    @GetMapping("getTotalQuantityByEachMonthAndYear/{year}")
    public List<BarChart> getTotalQuantityByEachMonthAndYear(@PathVariable("year")int year){
        return suppliesServices.getTotalQuantityByEachMonthAndYear(year);
    }

}
