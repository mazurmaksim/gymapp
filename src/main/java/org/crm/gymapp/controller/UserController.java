package org.crm.gymapp.controller;

import org.crm.gymapp.dto.LoginDAO;
import org.crm.gymapp.dto.UserDTO;
import org.crm.gymapp.entity.UsersEntity;
import org.crm.gymapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
public class UserController {
    @Value("${spring.application.name}")
    private String appName;
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public UserDTO getUser(@RequestParam String userId) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userService.getUserById(UUID.fromString(userId)), UserDTO.class);
    }

    @PostMapping("/user/save")
    public UserDTO saveUser(@RequestBody UserDTO userDTO) {
        ModelMapper modelMapper = new ModelMapper();
        userDTO.setRegDate(LocalDateTime.now());
        UsersEntity map = modelMapper.map(userDTO, UsersEntity.class);
        userService.saveUser(map);
        return modelMapper.map(map, UserDTO.class);
    }
}
