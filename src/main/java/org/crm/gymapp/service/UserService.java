package org.crm.gymapp.service;

import org.crm.gymapp.entity.UsersEntity;
import org.crm.gymapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UsersEntity getUserByUsername(String username) {
       return userRepository.findByUsername(username);
    }

    public UsersEntity getUserById(UUID uuid) {
        return userRepository.findById(uuid);
    }

    public void saveUser(UsersEntity user) {
        userRepository.save(user);
    }
}
