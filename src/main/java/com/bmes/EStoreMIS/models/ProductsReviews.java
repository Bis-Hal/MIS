package com.bmes.EStoreMIS.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "Products Review")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductsReviews {
    @GeneratedValue
    @UuidGenerator
    @Id
    private UUID reviewId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId",
            insertable = false,
            updatable = false)
    private Customers customers;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "productId", updatable = false, insertable = false)
    private Products products;

    @Column(name = "productId")
    private UUID productId;

    @Column(name = "customerId")
    private UUID customerId;

    @Column(name = "comments")
    private String comments;

    @Column(name = "Stars")
    private int stars;
}
