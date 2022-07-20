package com.example.lastproject.service;


import com.example.lastproject.domain.BankAccount;

import com.example.lastproject.exception.BankAccountNotFoundException;
import com.example.lastproject.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankAccountDbService {
    private final BankAccountRepository bankAccountRepository;

    public List<BankAccount> getBankAccounts() {
        return bankAccountRepository.findAll();
    }

    public BankAccount getBankAccountsById(Long ID) throws BankAccountNotFoundException {
        return bankAccountRepository.findById(ID).orElseThrow(BankAccountNotFoundException::new);
    }

    public BankAccount saveBankAccount(final BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }



}
