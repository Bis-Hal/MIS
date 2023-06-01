package com.bmes.EStoreMIS.Repository;

import com.bmes.EStoreMIS.models.Transactions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, UUID> {
    @Query(nativeQuery = true, value = "SELECT SUM(amount) from TRANSACTIONS WHERE type_id = ?")
    Long sumAmountByTransactionTypeId(UUID uuid);

}
