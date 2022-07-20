package com.example.lastproject.service;


import com.example.lastproject.domain.Card;
import com.example.lastproject.exception.CardNotFoundException;
import com.example.lastproject.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardDbService {
    private final CardRepository cardRepository;

    public List<Card> getCards() {
        return cardRepository.findAll();
    }

    public Card getCardById(Long ID) throws CardNotFoundException {
        return cardRepository.findById(ID).orElseThrow(CardNotFoundException::new);
    }

    public Card saveCard(final Card card) {
        return cardRepository.save(card);
    }
}
