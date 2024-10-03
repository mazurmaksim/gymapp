package org.crm.gymapp.controller;

import org.crm.gymapp.dto.UsersDto;
import org.crm.gymapp.entity.UsersEntity;
import org.crm.gymapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
public class UserController {
    @Value("${spring.application.name}")
    private String appName;
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public UsersDto getUser(@RequestParam String userId) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userService.getUserById(UUID.fromString(userId)), UsersDto.class);
    }

    @PostMapping("/user/save")
    public UsersDto saveUser(@RequestBody UsersDto userDTO) {
        ModelMapper modelMapper = new ModelMapper();
        userDTO.setRegDate(LocalDateTime.now());
        UsersEntity map = modelMapper.map(userDTO, UsersEntity.class);
        userService.saveUser(map);
        return modelMapper.map(map, UsersDto.class);
    }
}
