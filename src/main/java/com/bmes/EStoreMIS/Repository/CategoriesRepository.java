package com.bmes.EStoreMIS.Repository;

import com.bmes.EStoreMIS.models.lookUps.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, UUID> {
    Categories findByCategories(String categories);

}
