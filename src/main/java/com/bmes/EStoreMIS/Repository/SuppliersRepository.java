package com.bmes.EStoreMIS.Repository;

import com.bmes.EStoreMIS.models.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SuppliersRepository extends JpaRepository<Suppliers, UUID> {
    Suppliers findSupplierNameBySuppliersId(UUID suppliersId);
}
