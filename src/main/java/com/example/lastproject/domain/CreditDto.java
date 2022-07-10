package com.example.lastproject.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;


import java.time.LocalDate;


@Getter
@AllArgsConstructor
public class CreditDto {

    private Long id;

    private int value;

    private LocalDate paymentDate;

    private int startValue;

    private Long userID;

    private CreditStatus status;
}
