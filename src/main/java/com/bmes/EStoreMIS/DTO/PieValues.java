package com.bmes.EStoreMIS.DTO;


import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PieValues {
    private String title;
    private List<PieEntry> pieEntries;
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class PieEntry{
        private Float value;
        private String label;
    }
}
