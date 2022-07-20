package com.example.lastproject.mapper;

import com.example.lastproject.domain.User;
import com.example.lastproject.domain.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMapper {

    public User mapToUser(final UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getLogin(),
                userDto.getPassword(),
                userDto.getName(),
                userDto.getSurname(),
                userDto.getPhoneNumber(),
                userDto.getEmail(),
                userDto.getAccountId(),
                userDto.isLogged()
        );
    }

    public UserDto mapToUserDto(final User user){
        return new UserDto( user.getId(),
                user.getLogin(),
                user.getPassword(),
                user.getName(),
                user.getSurname(),
                user.getPhoneNumber(),
                user.getEmail(),
                user.getAccountId(),
                user.isLogged()
        );
    }

    public List<UserDto> mapToUserDtoList(final List<User> userList){
        return userList.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }

}
