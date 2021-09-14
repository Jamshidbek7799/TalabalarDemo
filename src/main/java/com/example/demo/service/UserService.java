package com.example.demo.service;

import com.example.demo.dto.UserCreateDto;
import com.example.demo.dto.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<List<UserDto>> getAllUsers();

    UserDto createUser(UserCreateDto dto);
}
