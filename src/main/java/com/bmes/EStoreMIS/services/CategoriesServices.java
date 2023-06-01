package com.bmes.EStoreMIS.services;

import com.bmes.EStoreMIS.Repository.CategoriesRepository;
import com.bmes.EStoreMIS.models.lookUps.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesServices {

    @Autowired
    private CategoriesRepository categoriesRepository;

    public void setAllCategories(List<Categories> categories) {
        categoriesRepository.saveAll(categories);
    }

    public void setCategory(Categories categories) {
        categoriesRepository.save(categories);
    }

    public List<Categories> getAllCategories() {
        return categoriesRepository.findAll();
    }
}
