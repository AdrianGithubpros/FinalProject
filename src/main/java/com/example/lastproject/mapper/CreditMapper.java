package com.example.lastproject.mapper;


import com.example.lastproject.domain.Credit;
import com.example.lastproject.domain.CreditDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CreditMapper {

    public Credit mapToCredit(final CreditDto creditDto){

        return new Credit(
                creditDto.getId(),
                creditDto.getValue(),
                creditDto.getPaymentDate(),
                creditDto.getStartValue(),
                creditDto.getUserID(),
                creditDto.getStatus());
    }

    public CreditDto mapToCreditDto(final Credit credit){
        return new CreditDto(
                credit.getId(),
                credit.getValue(),
                credit.getPaymentDate(),
                credit.getStartValue(),
                credit.getUserID(),
                credit.getStatus());
    }

    public List<CreditDto> mapToCreditDtoList(final List<Credit> creditList ){
        return creditList.stream()
                .map(this::mapToCreditDto)
                .collect(Collectors.toList());
    }

}
