package com.example.lastproject.controller;

import com.example.lastproject.domain.Credit;
import com.example.lastproject.domain.CreditDto;
import com.example.lastproject.domain.User;
import com.example.lastproject.domain.UserDto;
import com.example.lastproject.exception.CreditNotFoundException;
import com.example.lastproject.exception.UserNotFoundException;
import com.example.lastproject.mapper.CreditMapper;
import com.example.lastproject.mapper.UserMapper;
import com.example.lastproject.service.CreditDbService;
import com.example.lastproject.service.UserDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/User")
@RequiredArgsConstructor
public class UserController {

    private final UserDbService userDbService;
    private final UserMapper userMapper;

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        List<User> users = userDbService.getAllUsers();
        return ResponseEntity.ok(userMapper.mapToUserDtoList(users));
    }

    @GetMapping(value = "{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long userId) throws UserNotFoundException {
        return ResponseEntity.ok(userMapper.mapToUserDto(userDbService.getUserById(userId)));
    }


    @PutMapping
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        User userSaved = userDbService.saveUser(user);
        return ResponseEntity.ok(userMapper.mapToUserDto(userSaved));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        userDbService.saveUser(user);
        return ResponseEntity.ok().build();
    }



}
