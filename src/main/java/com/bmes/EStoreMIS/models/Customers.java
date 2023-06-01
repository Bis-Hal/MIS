package com.bmes.EStoreMIS.models;

import com.bmes.EStoreMIS.models.lookUps.Gender;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.validation.annotation.Validated;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "Customers")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customers {
    @GeneratedValue
    @UuidGenerator
    @Id
    private UUID customerId;
    @Column(name = "First Name")
    private String firstName;

    @Column(name = "Last Name")
    private String lastName;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "Age")
    private Integer age;

    @JoinColumn(name = "genderId", updatable = false, insertable = false)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Gender gender;

    @Column(name = "genderId")
    private UUID genderId;

    @Column(name = "Contact")
    private String contact;

    @Column(name = "Address")
    private String Address;

    @Embedded
    private Time time;

    @Embedded
    private Login login;

}
