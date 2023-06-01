package com.bmes.EStoreMIS.DTO;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Mapping {
    private UUID index;
    private Long value;
}
