package com.bmes.EStoreMIS.DTO;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BarChart {
    private int year;
    private List<Bar> barEntriesMonths;
    private long previous;
    private long current;
    private double indicator;
    private int arrow;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    @Builder
    public static class Bar{
        private int month;
        private float quantity;
    }

}
