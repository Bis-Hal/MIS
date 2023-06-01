package com.bmes.EStoreMIS.controllers;

import com.bmes.EStoreMIS.Repository.SuppliersRepository;
import com.bmes.EStoreMIS.models.Suppliers;
import com.bmes.EStoreMIS.models.Time;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SuppliersControllerTest {

    @Autowired
    SuppliersRepository suppliersRepository;
    @Test
    void setSuppliers() {
    }

    @Test
    void setSupplier() {
        LocalDate localDate = LocalDate.now();

        Time time = Time.builder()
                .year(localDate.getYear())
                .days(localDate.getDayOfMonth())
                .month(localDate.getMonthValue())
                .time(LocalTime.now())
                .build();

        Suppliers suppliers = Suppliers.builder()
                .supplierName("Xyz Supplier")
                .contact("9843807589")
                .time(time)
                .supplierLocation("Banglamukhi")
                .build();
        suppliersRepository.save(suppliers);
    }
}