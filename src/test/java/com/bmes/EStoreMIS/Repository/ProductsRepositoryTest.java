package com.bmes.EStoreMIS.Repository;

import com.bmes.EStoreMIS.models.Products;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductsRepositoryTest {

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    CategoriesRepository categoriesRepository;

    @Test
    void set(){

        productsRepository.save( Products.builder()
                .productName("Crystal")
                .categoriesId(categoriesRepository.findByCategories("Mens Foot Wear").getCategoriesId())
                .cost(800)
                .price(1000)
                .build());
    }
}