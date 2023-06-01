package com.bmes.EStoreMIS.dao;

import com.bmes.EStoreMIS.Repository.ProductsRepository;
import com.bmes.EStoreMIS.Repository.SuppliesRepository;
import com.bmes.EStoreMIS.DTO.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Repository
public class SuppliesDao {
    @Autowired
    SuppliesRepository suppliesRepository;

    @Autowired
    ProductsRepository productsRepository;

    public Long getTotalQuantityByEachMonthAndYear(int year, int month){
        AtomicReference<Long> sumQuantity= new AtomicReference<>(0L);
        suppliesRepository.sumQuantityByTimeMonthAndTimeYear(month, year).ifPresent(sumQuantity::set);
        return sumQuantity.get();
    }

    public List<Mapping> getSuppliesInfo(){
        List<Mapping> mappings = new ArrayList<>();
        productsRepository.findAll().forEach(products -> {
            mappings.add(new Mapping(products.getProductId(),suppliesRepository.sumTransactionsAmountByProductId(products.getProductId())));
        });
        return mappings;
    }
}
