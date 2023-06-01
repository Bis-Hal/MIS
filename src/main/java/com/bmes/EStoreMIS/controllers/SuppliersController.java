package com.bmes.EStoreMIS.controllers;

import com.bmes.EStoreMIS.models.Suppliers;
import com.bmes.EStoreMIS.services.SuppliersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("suppliers")
public class SuppliersController {

    @Autowired
    private SuppliersServices suppliersServices;

    @PostMapping("setSuppliers")
    public void setSuppliers(@RequestBody List<Suppliers> suppliers){
        suppliersServices.setSuppliers(suppliers);
    }

    @PostMapping("setSupplier")
    public void setSupplier(@RequestBody Suppliers suppliers){
        suppliersServices.setSupplier(suppliers);
    }

    @GetMapping("getSuppliers")
    public List<Suppliers> setSuppliers(){
        return suppliersServices.getSuppliers();
    }

}
