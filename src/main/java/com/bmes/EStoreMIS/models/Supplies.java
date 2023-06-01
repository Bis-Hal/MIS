package com.bmes.EStoreMIS.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "Supplies")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Supplies {

    @GeneratedValue
    @UuidGenerator
    @Id
    private UUID suppliesId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "suppliersId",
            updatable = false,
            insertable = false)
    private Suppliers suppliers;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "productId",
            updatable = false,
            insertable = false)
    private Products products;

    @Column(name = "suppliersId")
    private UUID suppliersId;

    @Column(name = "productId")
    private UUID productId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "transactionId")
    private Transactions transactions;

    @Column(name = "Quantity")
    private long quantity;

    @Column(name = "Batch")
    private String batch;

    @Embedded
    private Time time;

}
