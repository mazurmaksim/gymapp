package org.crm.gymapp.controller;

import org.crm.gymapp.dto.UsersDto;
import org.crm.gymapp.entity.UsersEntity;
import org.crm.gymapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AdminController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    public AdminController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/admin/users")
    public List<UsersDto> getUsers() {
        return mapList(userService.getAllUsers(), modelMapper);
    }

    List<UsersDto> mapList(List<UsersEntity> source, ModelMapper modelMapper) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, UsersDto.class))
                .collect(Collectors.toList());
    }
}
