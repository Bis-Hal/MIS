package com.bmes.EStoreMIS.services;

import com.bmes.EStoreMIS.Repository.SuppliersRepository;
import com.bmes.EStoreMIS.models.Suppliers;
import com.bmes.EStoreMIS.models.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class SuppliersServices {
    @Autowired
    private SuppliersRepository suppliersRepository;

    public void setSuppliers(List<Suppliers> suppliers) {
        suppliersRepository.saveAll(suppliers);
    }

    public void setSupplier(Suppliers suppliers) {


        suppliers.setTime(SuppliersServices.getTime());
        suppliersRepository.save(suppliers);


    }

    public List<Suppliers> getSuppliers() {
        return suppliersRepository.findAll();
    }

    public static Time getTime() {

        return Time.builder()
                .time(LocalTime.now())
                .year(LocalDate.now().getYear())
                .month(LocalDate.now().getMonthValue())
                .days(LocalDate.now().getDayOfMonth())
                .build();
    }
}
