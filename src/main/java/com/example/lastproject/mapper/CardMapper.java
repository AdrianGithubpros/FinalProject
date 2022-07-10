package com.example.lastproject.mapper;


import com.example.lastproject.domain.Card;
import com.example.lastproject.domain.CardDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardMapper {

    public Card mapToCard(final CardDto cardDto){
        return new Card(
                cardDto.getId(),
                cardDto.getNumber(),
                cardDto.getCvvNumber(),
                cardDto.getCardStatus(),
                cardDto.getCardType(),
                cardDto.getPinCode(),
                cardDto.getAccountID()
        );
    }

    public CardDto mapToCardDto(final Card card){
        return new CardDto(
                card.getId(),
                card.getNumber(),
                card.getCvvNumber(),
                card.getCardStatus(),
                card.getCardType(),
                card.getPinCode(),
                card.getAccountID()
        );
    }

    public List<CardDto> mapToCardDtoList(final List<Card> cardList){
        return cardList.stream()
                .map(this::mapToCardDto)
                .collect(Collectors.toList());

    }

}
