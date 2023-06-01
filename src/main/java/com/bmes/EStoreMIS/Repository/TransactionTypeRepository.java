package com.bmes.EStoreMIS.Repository;

import com.bmes.EStoreMIS.models.lookUps.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransactionTypeRepository extends JpaRepository<TransactionType, UUID> {
    TransactionType findByType(String type);
}
