package com.bmes.EStoreMIS.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.annotation.Immutable;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Immutable
public class EachProductSales {
    @Id
    private UUID productId;
    private Long quantity;
}
