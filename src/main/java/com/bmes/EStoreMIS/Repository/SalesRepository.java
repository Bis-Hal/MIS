package com.bmes.EStoreMIS.Repository;

import com.bmes.EStoreMIS.models.Sales;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SalesRepository extends JpaRepository<Sales, UUID> {
    List<Sales> findByTimeYear(int year);
    @Query(value = "SELECT SUM(quantity) FROM SALES WHERE YEAR = ?", nativeQuery = true)
    Optional<Long> sumQuantity(int year);


    @Query(nativeQuery = true, value = "SELECT s.PRODUCT_ID, SUM(s.QUANTITY) FROM SALES as s WHERE s.YEAR=? AND s.MONTH = ? GROUP BY s.PRODUCT_ID")
    List<Object> sumQuantityByProductIdAndMonth(@Qualifier("year") int year, @Qualifier("month") int months);
//    List<Sales> findByTimeYearAndTimeMonth(int currentYear, int value);
}
