package com.bmes.EStoreMIS.services;

import com.bmes.EStoreMIS.Repository.ProductsRepository;
import com.bmes.EStoreMIS.models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {
    @Autowired
    private ProductsRepository productsRepository;

    public void setProducts(List<Products> products) {
        productsRepository.saveAll(products);
    }

    public void setProduct(Products products) {
        productsRepository.save(products);
    }

    public List<Products> getProducts() {
        return productsRepository.findAll();
    }
}
