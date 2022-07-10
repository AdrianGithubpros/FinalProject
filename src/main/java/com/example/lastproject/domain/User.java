package com.example.lastproject.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "login", unique = true)
    private int login;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "phoneNumber")
    private int phoneNumber;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "account", unique = true)
    private Long accountId;
    @Column(name = "logged")
    private boolean logged;




}
