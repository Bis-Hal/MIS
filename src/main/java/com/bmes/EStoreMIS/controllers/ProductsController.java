package com.bmes.EStoreMIS.controllers;

import com.bmes.EStoreMIS.models.Products;
import com.bmes.EStoreMIS.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductsController {

    @Autowired
    private ProductServices productServices;

    @PostMapping("setProducts")
    public void setProducts(@RequestBody List<Products> products){
        productServices.setProducts(products);
    }

    @PostMapping("setProduct")
    public void setProduct(@RequestBody Products products){
        productServices.setProduct(products);
    }

    @GetMapping("getProducts")
    public List<Products> getProducts(){
        return productServices.getProducts();
    }

    @GetMapping("getProducts/all")
    public List<Products> getAllProducts(){
        return productServices.getProducts();
    }


}
