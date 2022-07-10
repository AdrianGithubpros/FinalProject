package com.example.lastproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;


import java.util.List;


@Getter
@AllArgsConstructor
public class BankAccountDto {

    private Long id;

    private long userId;

    private int availableFunds;

    private int blockedFunds;

    private BankAccountStatus bankAccountStatus;

    private List<Credit> credits;

    private List<Card> cards;

    private List<Record> records;
}
