package com.bmes.EStoreMIS.models.lookUps;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "Transaction Type")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionType {
    @GeneratedValue
    @UuidGenerator
    @Id
    private UUID typeId;

    @Column(name = "Type")
    private String type;
}
