package com.bmes.EStoreMIS.controllers;

import com.bmes.EStoreMIS.models.lookUps.Gender;
import com.bmes.EStoreMIS.services.GenderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("genders")
public class GenderController {

    @Autowired
    private GenderServices genderServices;

    @PostMapping("setGender")
    public void setGender(){
        genderServices.setGender();
    }

    @GetMapping("getAllGenders")
    public List<Gender> getAllGenders(){
        return genderServices.getAllGenders();
    }


}
