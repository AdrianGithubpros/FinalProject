package com.example.lastproject.service;

import com.example.lastproject.domain.Credit;
import com.example.lastproject.exception.CreditNotFoundException;
import com.example.lastproject.repository.CreditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditDbService {
    private final CreditRepository creditRepository;

    public List<Credit> getAllCredits() {
        return creditRepository.findAll();
    }

    public Credit getCreditById(Long id) throws CreditNotFoundException {
        return creditRepository.findById(id).orElseThrow(CreditNotFoundException::new);
    }

    public Credit saveCredit(final Credit credit) {
        return creditRepository.save(credit);
    }
}
