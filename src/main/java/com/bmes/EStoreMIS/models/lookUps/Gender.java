package com.bmes.EStoreMIS.models.lookUps;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "Gender")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Gender {
    @GeneratedValue
    @UuidGenerator
    @Id
    private UUID genderID;

    @Column(name = "Gender")
    private String gender;
}
