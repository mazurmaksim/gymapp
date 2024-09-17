package org.crm.gymapp.controller;

import org.crm.gymapp.dto.UserDTO;
import org.crm.gymapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public UserDTO getUser(@RequestParam String userName) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userService.getUserByUsername(userName), UserDTO.class);
    }
}
