package com.bmes.EStoreMIS.services;

import com.bmes.EStoreMIS.Repository.*;
import com.bmes.EStoreMIS.dao.SalesDao;
import com.bmes.EStoreMIS.models.*;
import com.bmes.EStoreMIS.models.lookUps.Finance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.util.*;

@SpringBootTest
class SalesServicesTest {

    @Autowired
    SalesRepository salesRepository;

    @Autowired
    SalesDao salesDao;

    @Autowired
    SalesServices salesServices;
    @Autowired
    CustomersRepository customersRepository;
    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    FinanceRepository financeRepository;

    @Autowired
    TransactionTypeRepository transactionTypeRepository;

    @Test
    void getSalesByYear() {

        List<Sales> sales = new ArrayList<>(salesRepository.findByTimeYear(2023));
        System.out.println(sales.size());
        sales.forEach(sales1 -> {
            System.out.println(sales1.getTime().getMonth());
        });
    }

    int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    @Test
    void setSales() {


        Optional<Customers> customerId = customersRepository.findById(UUID.fromString("3b637d2f-08cd-4f4b-ad49-859e736c99d8"));
        Optional<Products> productId = productsRepository.findById(UUID.fromString("ce6e7f19-ba64-4e51-ab8c-9d1272ca87cc"));
        Optional<Finance> financeId = financeRepository.findById(UUID.fromString("43736981-adb5-4122-9d9e-4f81abb5a3d7"));
//                LocalDate localDate = LocalDate.now();
        Time time = Time.builder()
                .days(12)
                .time(LocalTime.now())
                .year(2023)
                .month(12)
                .build();


        if (productId.isPresent()) {
            System.out.println(productId.get().getProductId());
            if (customerId.isPresent()) {
                System.out.println(customerId.get().getCustomerId());
                if (financeId.isPresent()) {
                    System.out.println(financeId.get().getFinanceId());
                    long amount = 2_000;
                    int discount = 30;
                    long total = amount + discount;
                    Transactions transactions = Transactions.builder()
                            .financeId(financeId.get().getFinanceId())
                            .transactionTypeId(transactionTypeRepository.findByType("Received").getTypeId())
                            .amount(amount)
                            .discount(discount)
                            .time(time)
                            .total(total)
                            .build();

                    Sales sales = Sales.builder()
                            .customerId(customerId.get().getCustomerId())
                            .productId(productId.get().getProductId())
                            .quantity(200)
                            .time(time)
                            .transaction(transactions)
                            .build();
                    System.out.println(sales);
                    salesRepository.save(sales);
                }
            }
        }

    }




@Test
public void getSalesDataByFromYearToYear(){
//        int currentYear = 2023;
//        int previousYear = currentYear -1;
//        int upOrDown = 0;
////        int size = salesServices.getSalesDataByFromYearToYear(2023,2023).size();
//        AtomicLong currentYearTotal = new AtomicLong(0);
//        AtomicLong previousYearTotal = new AtomicLong(1000);
//        salesRepository.sumQuantity(currentYear).ifPresent(currentYearTotal::set);
//        salesRepository.sumQuantity(previousYear).ifPresent(previousYearTotal::set);
//
//        double change = currentYearTotal.longValue() - previousYearTotal.longValue();
//        double previous =  previousYearTotal.longValue() !=0 ? previousYearTotal.longValue() : 1L;
//        double indicator = Math.abs(((change)/previous)*100);

        int change=10-50;
        int value=change>0?1:-1;
        int result=change==0?0:value;
        System.out.println(result);
//        System.out.println(indicator);

        }

@Test
    void sales(){

    for(Object obj : salesRepository.sumQuantityByProductIdAndMonth(2023,12)){

        String str = new String((String) obj);
        System.out.println(str);
    }
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory( "Sales_D" );
//    EntityManager em = emf.createEntityManager();
//    em.getTransaction().begin( );
//    CriteriaBuilder cb = em.getCriteriaBuilder();
//    CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
//    Root<Sales> stud = cq.from(Sales.class);
//    cq.multiselect(stud.get("genderId"),cb.count(stud)).groupBy(stud.get("genderId"));
//
//
//    System.out.print("s_age");
//    System.out.println("\t Count");
//    List<Object[]> list = em.createQuery(cq).getResultList();
//    for(Object[] object : list){
//        System.out.println(object[0] + "     " + object[1]);

    }
}
