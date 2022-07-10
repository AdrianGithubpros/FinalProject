package com.example.lastproject.service;


import com.example.lastproject.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankAccountDbService {
    private final BankAccountRepository bankAccountRepository;
}
