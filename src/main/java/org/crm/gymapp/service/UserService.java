package org.crm.gymapp.service;

import org.crm.gymapp.dto.UserDTO;
import org.crm.gymapp.entity.UsersEntity;
import org.crm.gymapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UsersEntity getUserByUsername(String username) {
       return userRepository.findByUsername(username);
    }

}
