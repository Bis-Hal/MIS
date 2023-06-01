package com.bmes.EStoreMIS.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "Sales")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sales {
    @GeneratedValue
    @UuidGenerator
    @Id
    private UUID salesId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "productId",
            updatable = false,
            insertable = false)
    private Products products;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId",
            updatable = false,
            insertable = false)
    private Customers customers;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "transactionId")
    private Transactions transaction;

    @Column(name = "customerId")
    private UUID customerId;

    @Column(name = "productId")
    private UUID productId;

    @Column(name = "Quantity")
    private long quantity;

    @Embedded
    private Time time;

}
