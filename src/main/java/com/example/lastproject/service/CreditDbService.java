package com.example.lastproject.service;

import com.example.lastproject.repository.CreditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreditDbService {
    private final CreditRepository creditRepository;
}
