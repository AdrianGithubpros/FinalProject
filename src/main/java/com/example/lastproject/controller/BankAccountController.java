package com.example.lastproject.controller;


import com.example.lastproject.domain.*;
import com.example.lastproject.exception.BankAccountNotFoundException;
import com.example.lastproject.mapper.BankAccountMapper;
import com.example.lastproject.service.BankAccountDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/BankAccount")
@RequiredArgsConstructor
public class BankAccountController {

    private final BankAccountDbService bankAccountDbService;
    private final BankAccountMapper bankAccountMapper;

    @GetMapping
    public ResponseEntity<List<BankAccountDto>> getBankAccounts() {
        List<BankAccount> bankAccount = bankAccountDbService.getBankAccounts();
        return ResponseEntity.ok(bankAccountMapper.mapToBankAccountDtoList(bankAccount));
    }

    @GetMapping(value = "{bankAccountId}")
    public ResponseEntity<BankAccountDto> getBankAccount(@PathVariable Long bankAccountId) throws BankAccountNotFoundException{
        return ResponseEntity.ok(bankAccountMapper.mapToBankAccountDto(bankAccountDbService.getBankAccountsById(bankAccountId)));
  }


    @PutMapping
    public ResponseEntity<BankAccountDto> updateBankAccount(@RequestBody BankAccountDto bankAccountDto) {
        BankAccount bankAccount = bankAccountMapper.mapToBankAccount(bankAccountDto);
        BankAccount bankAccountSaved = bankAccountDbService.saveBankAccount(bankAccount);
        return ResponseEntity.ok(bankAccountMapper.mapToBankAccountDto(bankAccountSaved));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createBankAccount(@RequestBody BankAccountDto bankAccountDto) {
        BankAccount bankAccount = bankAccountMapper.mapToBankAccount(bankAccountDto);
        bankAccountDbService.saveBankAccount(bankAccount);
        return ResponseEntity.ok().build();
    }





}
