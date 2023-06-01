package com.bmes.EStoreMIS.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SuppliesServicesTest {

        @Autowired
        SuppliesServices suppliesServices;
    @BeforeEach
    void setUp() {
    }
    @Test
    void testing(){
        suppliesServices.getSuppliesInfo();
    }


}