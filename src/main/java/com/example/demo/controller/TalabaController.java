package com.example.demo.controller;

import com.example.demo.dto.UserCreateDto;
import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/contr")
public class TalabaController {

    @Autowired
    private UserService userService;

    @GetMapping("/get/users")
    ResponseEntity<List<UserDto>> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/add")
    ResponseEntity<?> createUser(@RequestBody UserCreateDto dto){
        UserDto userDto = userService.createUser(dto);
        return ResponseEntity.ok(userDto);
    }


}
