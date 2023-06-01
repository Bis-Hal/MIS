package com.bmes.EStoreMIS.models;

import com.bmes.EStoreMIS.models.lookUps.Finance;
import com.bmes.EStoreMIS.models.lookUps.TransactionType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "Transactions")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transactions {
    @GeneratedValue
    @UuidGenerator
    @Id
    private UUID transactionId;

    @JoinColumn(name = "financeId",
            updatable = false,
            insertable = false)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Finance finance;
    
    @Column(name = "financeId")
    private UUID financeId;

    @Embedded
    private Time time;

    @Column(name = "Amount")
    private Long amount;

    @Column(name = "Discount")
    private int discount;

    @Column(name = "Total")
    private Long total;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "TypeId", insertable = false, updatable = false)
    private TransactionType transactionType;


    @Column(name = "TypeId")
    private UUID transactionTypeId;


}
