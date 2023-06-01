package com.bmes.EStoreMIS.Repository;

import com.bmes.EStoreMIS.models.lookUps.Finance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FinanceRepository extends JpaRepository<Finance, UUID> {

    Finance findByFinance(String name);
}
