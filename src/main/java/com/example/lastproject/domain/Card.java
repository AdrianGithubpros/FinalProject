package com.example.lastproject.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "CARDS")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "Number")
    private int number;

    @Column(name = "CVV_Number")
    private int cvvNumber;

    @Column(name = "Status")
    private CardStatus cardStatus;

    @Column(name = "Type")
    private CardType cardType;

    @Column(name = "Pin_Code")
    private int pinCode;

    @Column(name = "Account_Id")
    private Long accountID;


}
