package com.example.lastproject.service;


import com.example.lastproject.domain.Record;
import com.example.lastproject.domain.User;
import com.example.lastproject.exception.UserNotFoundException;
import com.example.lastproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDbService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long ID) throws UserNotFoundException {
        return userRepository.findById(ID).orElseThrow(UserNotFoundException::new);
    }


    public User saveUser(final User user) {
        return userRepository.save(user);
    }

}
