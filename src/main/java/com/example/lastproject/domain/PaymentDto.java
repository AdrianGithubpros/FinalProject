package com.example.lastproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PaymentDto {
    private String to;
    private int value;
    private Long accountId;
}
