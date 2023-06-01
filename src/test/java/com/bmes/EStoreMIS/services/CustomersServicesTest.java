package com.bmes.EStoreMIS.services;

import com.bmes.EStoreMIS.Repository.CustomersRepository;
import com.bmes.EStoreMIS.Repository.GenderRepository;
import com.bmes.EStoreMIS.models.Customers;
import com.bmes.EStoreMIS.models.Login;
import com.bmes.EStoreMIS.models.Time;
import com.bmes.EStoreMIS.models.lookUps.Gender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.Arrays;
import java.util.Random;
import java.util.random.RandomGenerator;

@SpringBootTest
class CustomersServicesTest {

    @Autowired
    CustomersRepository customersRepository;

    @Autowired
    GenderRepository genderRepository;
    @Autowired
    CustomersServices customersServices;

    private final int[] months = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    int[] data2 = {190,200,150,170,180,300,320,400,380,300,400,600};


//
//    UUID id = UUID.randomUUID();
//    UUID gender = UUID.randomUUID();

    void setUp() {
//        UUID genderId = genderRepository.findByGenderGetGenderId("Male");
//        LocalDate date = LocalDate.now();
//        Time time = Time.builder()
//                .year(date.getYear())
//                .month(date.getMonthValue())
//                .days(date.getDayOfMonth())
//                .time(LocalTime.now())
//                .build();
//
//        Login login = Login.builder()
//                .username("Mz3is7")
//                .email("bishalmaharjan17@gmail.com")
//                .password("bishalmaharjan")
//                .build();
//
//        Customers customers = Customers.builder()
//                .customerId(id)
//                .firstName("Buddha")
//                .lastName("Gautam")
//                .time(time)
//                .login(login)
//                .genderId(genderId)
//                .contact("9876543210")
//                .dob(Date.valueOf("2000-02-13"))
//                .Address("Kathmandu")
//                .build();
//
//        Mockito.when(customersRepository.save(customers)).thenReturn(customers);
    }

    @Test
    void setCustomer() {


        String[] genderes = {"Male","Female/'", "Others"};

            Arrays.stream(months).forEach(value -> {
                Random random = new Random();
                int x = random.nextInt(2);
                for (int i =0;i<data2[value-1];i++) {
                    Gender gender = genderRepository.findGenderIdByGender(genderes[x]);

                    LocalDate date = LocalDate.now();
                    Date dob = Date.valueOf("2010-02-13");

                    Time time = Time.builder()
                            .year(date.getYear())
                            .month(value)
                            .days(date.getDayOfMonth())
                            .time(LocalTime.now())
                            .build();


                    Login login = Login.builder()
                            .username("Mz3is7")
                            .email("bishalmaharjan17@gmail.com")
                            .password("bishalmaharjan")
                            .build();

                    Customers customers = Customers.builder()
                            .firstName("Siwa")
                            .lastName("Maharjan")
                            .time(time)
                            .login(login)
                            .genderId(gender.getGenderID())
                            .contact("9818496135")
                            .dob(dob)
                            .age(Period.between(dob.toLocalDate(), date).getYears())
                            .Address("Kathmandu")
                            .build();
                    customersServices.setCustomer(customers);
                }
            });

    }

    @Test
    public void customerNumber() {

        Arrays.stream(months).forEach(value -> {
            customersRepository.countCustomerIdByTimeMonthAndTimeYear(value,2023).ifPresent(System.out::println);
        });
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