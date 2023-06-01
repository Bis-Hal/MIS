package com.bmes.EStoreMIS.models.lookUps;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "Finance")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Finance {
    @UuidGenerator
    @GeneratedValue
    @Id
    private UUID financeId;

    @Column(name = "Finance")
    private String finance;
}
