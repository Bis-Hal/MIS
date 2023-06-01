package com.bmes.EStoreMIS.Repository;

import com.bmes.EStoreMIS.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductsRepository extends JpaRepository<Products, UUID> {
}
