package com.bmes.EStoreMIS.services;

import com.bmes.EStoreMIS.Repository.ProductReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsReviewsServices {
    @Autowired
    private ProductReviewsRepository productReviewsRepository;
}
