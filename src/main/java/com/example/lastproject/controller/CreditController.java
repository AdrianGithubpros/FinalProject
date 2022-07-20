package com.example.lastproject.controller;

import com.example.lastproject.domain.Card;
import com.example.lastproject.domain.CardDto;
import com.example.lastproject.domain.Credit;
import com.example.lastproject.domain.CreditDto;
import com.example.lastproject.exception.CardNotFoundException;
import com.example.lastproject.exception.CreditNotFoundException;
import com.example.lastproject.mapper.CardMapper;
import com.example.lastproject.mapper.CreditMapper;
import com.example.lastproject.service.CardDbService;
import com.example.lastproject.service.CreditDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/v1/Credit")
@RequiredArgsConstructor
public class CreditController {

    private final CreditDbService creditDbService;
    private final CreditMapper creditMapper;

    @GetMapping
    public ResponseEntity<List<CreditDto>> getCredits() {
        List<Credit> credits = creditDbService.getAllCredits();
        return ResponseEntity.ok(creditMapper.mapToCreditDtoList(credits));
    }

    @GetMapping(value = "{creditId}")
    public ResponseEntity<CreditDto> getCredit(@PathVariable Long creditId) throws CreditNotFoundException {
        return ResponseEntity.ok(creditMapper.mapToCreditDto(creditDbService.getCreditById(creditId)));
    }


    @PutMapping
    public ResponseEntity<CreditDto> updateCredit(@RequestBody CreditDto creditDto) {
        Credit credit = creditMapper.mapToCredit(creditDto);
        Credit creditSaved = creditDbService.saveCredit(credit);
        return ResponseEntity.ok(creditMapper.mapToCreditDto(creditSaved));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createCredit(@RequestBody CreditDto creditDto) {
        Credit credit = creditMapper.mapToCredit(creditDto);
        creditDbService.saveCredit(credit);
        return ResponseEntity.ok().build();
    }
}
