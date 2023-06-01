package com.bmes.EStoreMIS.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "Suppliers")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Suppliers {
    @GeneratedValue
    @UuidGenerator
    @Id
    private UUID suppliersId;

    @Column(name = "Supplier Name")
    private String supplierName;

    @Column(name = "Supplier Location")
    private String supplierLocation;

    @Column(name = "Contact")
    private String contact;

    @Embedded
    private Time time;
}
