package com.bmes.EStoreMIS.dao;

import com.bmes.EStoreMIS.Repository.CustomersRepository;
import com.bmes.EStoreMIS.Repository.GenderRepository;
import com.bmes.EStoreMIS.DTO.PieValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Repository
public class CustomersDao {

    @Autowired
    private CustomersRepository customersRepository;
    @Autowired
    private GenderRepository genderRepository;

    public List<PieValues> getTargetMarket() {
        float total = customersRepository.findAll().size();
        List<String> genders = List.of("Female", "Male", "Others");
        List<PieValues> pieValues = new ArrayList<>();
        List<PieValues.PieEntry> pieEntries = new ArrayList<>();
        genders.forEach(s -> {
            customersRepository.countCustomerIdByGenderId(genderRepository.findGenderIdByGender(s).getGenderID())
                    .ifPresent(
                            aLong -> {
                              pieEntries.add(new PieValues.PieEntry(((aLong)/total)*100,s));
                            });
        });

        List<PieValues.PieEntry> pieEntries1 = new ArrayList<>();


        getTargetMarketByAge().forEach((label,age) -> {
            pieEntries1.add(new PieValues.PieEntry((age / total) * 100,label));
        });


      pieValues.add(new PieValues("Gender", pieEntries));
      pieValues.add(new PieValues("Age",pieEntries1));
      return pieValues;

    }

    public HashMap<String, Float> getTargetMarketByAge() {
        List<String> label = List.of("Babies", "Kids", "Teens", "Youngsters", "Adult", "Olds");
        float babies = customersRepository.findByAgeGreaterThanEqualAndAgeLessThanEqual(0, 2).size();
        float kids = customersRepository.findByAgeGreaterThanEqualAndAgeLessThanEqual(3, 12).size();
        float teens = customersRepository.findByAgeGreaterThanEqualAndAgeLessThanEqual(13, 19).size();
        float youngsters = customersRepository.findByAgeGreaterThanEqualAndAgeLessThanEqual(20, 39).size();
        float adults = customersRepository.findByAgeGreaterThanEqualAndAgeLessThanEqual(40, 59).size();
        float olds = customersRepository.findByAgeGreaterThanEqualAndAgeLessThanEqual(60, 99).size();

        HashMap<String, Float> values = new HashMap<>();
        values.put(label.get(0), babies);
        values.put(label.get(1), kids);
        values.put(label.get(2), teens);
        values.put(label.get(3), youngsters);
        values.put(label.get(4), adults);
        values.put(label.get(5), olds);

        return values;
    }

    public Long getCustomerCountByYear(int month, int year) {
        AtomicReference<Long> customerCount = new AtomicReference<>(0L);
        customersRepository.countCustomerIdByTimeMonthAndTimeYear(month, year).ifPresent(customerCount::set);
        return customerCount.getAcquire();
    }
}
