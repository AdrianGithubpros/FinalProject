package com.example.lastproject.mapper;


import com.example.lastproject.domain.BankAccount;
import com.example.lastproject.domain.BankAccountDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankAccountMapper {

    public BankAccount mapToBankAccount(final BankAccountDto bankAccountDto){
        return new BankAccount(
                bankAccountDto.getId(),
                bankAccountDto.getUserId(),
                bankAccountDto.getAvailableFunds(),
                bankAccountDto.getBlockedFunds(),
                bankAccountDto.getBankAccountStatus(),
                bankAccountDto.getCredits(),
                bankAccountDto.getCards() ,
                bankAccountDto.getRecords());
    }

    public BankAccountDto mapToBankAccountDto(final BankAccount bankAccount){
        return new BankAccountDto(
                bankAccount.getId(),
                bankAccount.getUserId(),
                bankAccount.getAvailableFunds(),
                bankAccount.getBlockedFunds(),
                bankAccount.getBankAccountStatus(),
                bankAccount.getCredits(),
                bankAccount.getCards() ,
                bankAccount.getRecords());
    }

    public List<BankAccountDto> mapToBankAccountDtoList(final List<BankAccount> bankAccountList){
        return bankAccountList.stream()
                .map(this::mapToBankAccountDto)
                .collect(Collectors.toList());
    }

}
