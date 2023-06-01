package com.bmes.EStoreMIS.Repository;

import com.bmes.EStoreMIS.DTO.BarChart;
import com.bmes.EStoreMIS.models.Suppliers;
import com.bmes.EStoreMIS.models.Supplies;
import com.bmes.EStoreMIS.models.Time;
import com.bmes.EStoreMIS.models.Transactions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class SuppliesRepositoryTest {

    @Autowired
    FinanceRepository financeRepository;
    @Autowired
    TransactionTypeRepository transactionTypeRepository;

    @Autowired
    SuppliersRepository suppliersRepository;
    @Autowired
    SuppliesRepository suppliesRepository;
    
    @Autowired
    ProductsRepository productsRepository;
    @BeforeEach
    void setUp() {
    }

    private final int[] months = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    int[] data2 = {90,190,50,70,80,200,220,300,280,300,300,400};


    @Test
    void setSupplies(){
//        Arrays.stream(months).forEach(value -> {
            long count = suppliesRepository.countBatchBySuppliersId(UUID.fromString("cb2a47fc-e148-4f96-8ff9-be0583b15636"));
            Suppliers supplier = suppliersRepository.findSupplierNameBySuppliersId(UUID.fromString("4b1ee318-f663-415a-a69c-a37fe42a37fc"));
            boolean x = productsRepository.existsById(UUID.fromString("ce6e7f19-ba64-4e51-ab8c-9d1272ca87cc"));
            UUID productId =null;
            if (x)
                productId = UUID.fromString("ce6e7f19-ba64-4e51-ab8c-9d1272ca87cc");

            long amount = 30_000;
            int discount = 0;
            long total = amount - discount;
            LocalDate localDate = LocalDate.now();
            Time time = Time.builder()
                    .month(12)
                    .days(1)
                    .year(localDate.getYear())
                    .time(LocalTime.now())
                    .build();
            Transactions transactions = Transactions.builder()
                    .financeId(financeRepository.findByFinance("E-sewa").getFinanceId())
                    .time(time)
                    .amount(amount)
                    .discount(discount)
                    .transactionTypeId(transactionTypeRepository.findByType("Paid").getTypeId())
                    .total(total)
                    .build();
            String batch = "Batch"+localDate.getYear()+""+supplier.getSupplierName()+""+count;
            Supplies supplies = Supplies.builder()
                    .batch(batch)
                    .productId(productId)
                    .quantity(data2[11])
                    .transactions(transactions)
                    .time(time)
                    .suppliersId(UUID.fromString("4b1ee318-f663-415a-a69c-a37fe42a37fc"))
                    .build();

            suppliesRepository.save(supplies);

//        });


    }

    @Test
    void getBatchBySuppliersId(){
        List<BarChart> barCharts = new ArrayList<>();
        List<BarChart.Bar> bars = new ArrayList<>();

        for(int month = 1;month<13;month++){
//            bars.add(new BarChart.Bar(month,suppliesRepository.sumQuantityByTimeMonthAndTimeYear(month,2023)));
        }
        bars.forEach(System.out::println);

    }

    @Test
    void supply(){
        suppliesRepository.findAll().forEach(System.out::println);
    }

}