package com.bmes.EStoreMIS.services;

import com.bmes.EStoreMIS.Repository.GenderRepository;
import com.bmes.EStoreMIS.models.lookUps.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenderServices {

    @Autowired
    private GenderRepository genderRepository;

    public void setGender(){
        Gender MALE = Gender.builder().gender("Male").build();
        Gender FEMALE = Gender.builder().gender("Female").build();
        Gender OTHERS = Gender.builder().gender("Others").build();
        List<Gender> gender = List.of(MALE, FEMALE, OTHERS);
        genderRepository.saveAll(gender);
    }

    public List<Gender> getAllGenders() {
        return genderRepository.findAll();
    }
}
