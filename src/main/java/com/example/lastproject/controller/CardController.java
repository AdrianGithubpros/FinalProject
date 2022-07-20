package com.example.lastproject.controller;


import com.example.lastproject.domain.Card;
import com.example.lastproject.domain.CardDto;
import com.example.lastproject.exception.CardNotFoundException;
import com.example.lastproject.mapper.CardMapper;
import com.example.lastproject.service.CardDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/Card")
@RequiredArgsConstructor
public class CardController {


    private final CardDbService cardDbService;
    private final CardMapper cardMapper;

    @GetMapping
    public ResponseEntity<List<CardDto>> getCards() {
        List<Card> cards = cardDbService.getCards();
        return ResponseEntity.ok(cardMapper.mapToCardDtoList(cards));
    }

    @GetMapping(value = "{cardId}")
    public ResponseEntity<CardDto> getCard(@PathVariable Long cardId) throws CardNotFoundException {
        return ResponseEntity.ok(cardMapper.mapToCardDto(cardDbService.getCardById(cardId)));
    }


    @PutMapping
    public ResponseEntity<CardDto> updateCard(@RequestBody CardDto cardDto) {
        Card card = cardMapper.mapToCard(cardDto);
        Card cardSaved = cardDbService.saveCard(card);
        return ResponseEntity.ok(cardMapper.mapToCardDto(cardSaved));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createBCard(@RequestBody CardDto cardDto) {
        Card card = cardMapper.mapToCard(cardDto);
        cardDbService.saveCard(card);
        return ResponseEntity.ok().build();
    }
}
