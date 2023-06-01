package com.bmes.EStoreMIS.controllers;

import com.bmes.EStoreMIS.models.lookUps.Categories;
import com.bmes.EStoreMIS.services.CategoriesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoriesController {

    @Autowired
    private CategoriesServices categoriesServices;

    @PostMapping("setAllCategories")
    public void setAllCategories(@RequestBody List<Categories> categories){
        categoriesServices.setAllCategories(categories);
    }
    @PostMapping("setCategory")
    public void setCategories(@RequestBody Categories categories){
        categoriesServices.setCategory(categories);
    }

    @GetMapping("getAllCategories")
    public List<Categories> getAllCategories(){
        return categoriesServices.getAllCategories();
    }

}
