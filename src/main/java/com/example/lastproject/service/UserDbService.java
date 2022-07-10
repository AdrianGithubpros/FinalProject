package com.example.lastproject.service;


import com.example.lastproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDbService {
    private final UserRepository userRepository;
}
