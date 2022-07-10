package com.example.lastproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;




@Getter
@AllArgsConstructor
public class UserDto {

    private Long id;

    private int login;

    private String password;

    private String name;

    private String surname;

    private int phoneNumber;

    private String email;

    private Long accountId;

    private boolean logged;
}
