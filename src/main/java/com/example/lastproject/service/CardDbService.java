package com.example.lastproject.service;

import com.example.lastproject.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardDbService {
    private final CardRepository cardRepository;
}
