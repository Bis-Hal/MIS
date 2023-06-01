package com.bmes.EStoreMIS.Repository;

import com.bmes.EStoreMIS.models.Suppliers;
import com.bmes.EStoreMIS.models.Supplies;
import com.bmes.EStoreMIS.views.BatchCounter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

@Repository
public interface SuppliesRepository extends JpaRepository<Supplies, UUID> {

    @Query(value = "SELECT SUM(quantity) from SUPPLIES WHERE month = ? AND year = ?", nativeQuery = true)
    Optional<Long> sumQuantityByTimeMonthAndTimeYear(@Qualifier("month") int month, @Qualifier("year") int year);
    Long countBatchBySuppliersId(UUID supplierId);

    @Query(value = "SELECT SUM(amount) from SUPPLIES WHERE productId = ?", nativeQuery = true)

    Long sumTransactionsAmountByProductId(UUID productId);

}
