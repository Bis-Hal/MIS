package com.bmes.EStoreMIS.models.lookUps;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "Categories")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Categories {
    @GeneratedValue
    @UuidGenerator
    @Id
    private UUID categoriesId;

    @Column(name = "Categories")
    private String categories;

}
