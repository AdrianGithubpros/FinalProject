package com.example.lastproject.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CardDto {

    private Long id;

    private int number;

    private int cvvNumber;

    private CardStatus cardStatus;

    private CardType cardType;

    private int pinCode;

    private Long accountID;
}
