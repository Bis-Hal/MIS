package com.bmes.EStoreMIS.models;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Embeddable
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name = "year",
                column = @Column(name = "Year")
        ),
        @AttributeOverride(
                name = "month",
                column = @Column(name = "Month")
        ),
        @AttributeOverride(
                name = "days",
                column = @Column(name = "Days")
        ),
        @AttributeOverride(
                name = "time",
                column = @Column(name = "Time")
        ),
})
public class Time {
    private int year;
    private int month;
    private int days;
    private LocalTime time;
}
