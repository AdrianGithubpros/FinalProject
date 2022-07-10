package com.example.lastproject.domain;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CREDITS")
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @NotNull
    @Column(name = "ID_Credit", unique = true)
    private Long id;
    @Column(name = "Value")
    private int value;
    @Column(name = "Payment_Date")
    private LocalDate paymentDate;
    @Column(name = "Start_Value")
    private int startValue;
    @Column(name = "User_ID")
    private Long userID;
    @Column(name = "Status")
    private CreditStatus status;

}
