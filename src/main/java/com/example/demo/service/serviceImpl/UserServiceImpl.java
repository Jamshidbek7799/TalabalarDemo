package com.example.demo.service.serviceImpl;

import com.example.demo.dto.UserCreateDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserEntity> userEntities = userRepo.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        userEntities.forEach(userEntity -> {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(userEntity, userDto);
            userDtos.add(userDto);
        });
        return ResponseEntity.ok(userDtos);
    }

    @Override
    public UserDto createUser(UserCreateDto dto) {
        Optional<UserEntity> optional = userRepo.findByEmail(dto.getEmail());
        if (optional.isPresent())
            return null;
        UserEntity userEntity = new UserEntity(dto);
        userRepo.save(userEntity);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userEntity, userDto);
        return userDto;
    }
}
