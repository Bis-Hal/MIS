package com.bmes.EStoreMIS.views;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class BatchCounter {
    private int count;
    private UUID suppliersId;
}
