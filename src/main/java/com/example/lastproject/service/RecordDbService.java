package com.example.lastproject.service;

import com.example.lastproject.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecordDbService {
    private final RecordRepository recordRepository;
}
