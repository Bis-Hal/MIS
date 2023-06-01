package com.bmes.EStoreMIS.Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomersRepositoryTest {
    @Autowired
    CustomersRepository customersRepository;

    @Autowired
    GenderRepository genderRepository;


    @BeforeEach
    void setUp() {



    }

    @Test
    public void setCustomer() {
//        LocalDate currentDate = LocalDate.now();
//        UUID custom = UUID.randomUUID();
//
//        Time time = Time.builder()
//                .days(currentDate.getDayOfMonth())
//                .month(currentDate.getMonthValue())
//                .year(currentDate.getYear())
//                .time(LocalTime.now())
//                .build();
//
//        Customers customers = Customers.builder()
//                .time(time)
//                .customerId(UUID.randomUUID())
//                .Address("Kathmandu")
//                .contact("9818496135")
//                .dob(Date.valueOf("2000-01-01"))
//                .firstName("Bishal")
//                .lastName("Maharjan")
//                .gender(custom)
//                .build();
//
//        customersRepository.save(customers);
    }

    @Test
    public void Customers() {

        double female = customersRepository.findByGenderId(genderRepository.findAll().get(0).getGenderID()).size();
        double male = customersRepository.findByGenderId(genderRepository.findAll().get(1).getGenderID()).size();
        double others = customersRepository.findByGenderId(genderRepository.findAll().get(2).getGenderID()).size();
        double total = customersRepository.findAll().size();
        System.out.println(total);
        System.out.println((female / total) * 100);
        System.out.println((male / total) * 100);
        System.out.println((others / total) * 100);


        double babies = customersRepository.findByAgeGreaterThanEqualAndAgeLessThanEqual(0, 2).size();
        double kids = customersRepository.findByAgeGreaterThanEqualAndAgeLessThanEqual(3, 12).size();
        double teens = customersRepository.findByAgeGreaterThanEqualAndAgeLessThanEqual(13, 19).size();
        double youngsters = customersRepository.findByAgeGreaterThanEqualAndAgeLessThanEqual(20, 39).size();
        double adults = customersRepository.findByAgeGreaterThanEqualAndAgeLessThanEqual(40, 59).size();
        double olds = customersRepository.findByAgeGreaterThanEqualAndAgeLessThanEqual(60, 99).size();
        System.out.println((babies / total) * 100);
        System.out.println((kids / total) * 100);
        System.out.println((teens / total) * 100);
        System.out.println((youngsters / total) * 100);
        System.out.println((adults / total) * 100);
        System.out.println((olds / total) * 100);
    }

    @Test
    public void getCus() {
        System.out.println(customersRepository.findAll().stream().filter(customers -> customers.getGender().getGender()).count());
    }
}