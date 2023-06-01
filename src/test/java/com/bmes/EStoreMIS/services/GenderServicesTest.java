package com.bmes.EStoreMIS.services;

import com.bmes.EStoreMIS.Repository.GenderRepository;
import com.bmes.EStoreMIS.models.lookUps.Gender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GenderServicesTest {


    @Autowired
    GenderServices genderServices;

    @Test
    void setGender() {
       genderServices.setGender();
    }
}