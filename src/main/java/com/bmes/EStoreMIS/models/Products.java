package com.bmes.EStoreMIS.models;

import com.bmes.EStoreMIS.models.lookUps.Categories;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "Products")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Products {
    @GeneratedValue
    @UuidGenerator
    @Id
    private UUID productId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "categoriesId",
            insertable = false,
            updatable = false)
    private Categories categories;

    @Column(name = "categoriesId")
    private UUID categoriesId;

    @Column(name = "Product Name")
    private String productName;

    @Column(name = "Cost")
    private long cost;

    @Column(name = "Price")
    private long price;
}
