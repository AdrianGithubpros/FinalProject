package com.example.lastproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "BANK_ACCOUNTS")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "user_id", unique = true)
    private long userId;
    @Column(name = "funds")
    private int availableFunds;
    @Column(name = "blocked_funds")
    private int blockedFunds;
    @Column(name = "acc_status")
    private BankAccountStatus bankAccountStatus;

    @OneToMany(
            targetEntity = Credit.class,
            mappedBy = "bankaccount",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Credit> credits;

    @OneToMany(
            targetEntity = Card.class,
            mappedBy = "bankaccount",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Card> cards;

    @OneToMany(
            targetEntity = Record.class,
            mappedBy = "bankaccount",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Record> records;
}
