package com.bmes.EStoreMIS.Repository;

import com.bmes.EStoreMIS.models.Customers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomersRepository extends JpaRepository<Customers, UUID> {
    List<Customers> findByGenderId(UUID genderId);
    Optional<Float> countCustomerIdByGenderId(UUID genderId);
    List<Customers> findByAgeGreaterThanEqualAndAgeLessThanEqual(int lowerLimit, int upperLimit);

    Optional<Long> countCustomerIdByTimeMonthAndTimeYear(int month ,int year);

//    @Query(value = "select count(gender_Id), gender from customers inner join gender where customers.gender_id = gender.genderid group by gender_id", nativeQuery = true)
//    List<> getGenderCount();























}
