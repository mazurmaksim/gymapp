package org.crm.gymapp.service;

import org.crm.gymapp.dto.SubscriptionDTO;
import org.crm.gymapp.dto.UserDTO;
import org.crm.gymapp.entity.SubscriptionsEntity;
import org.crm.gymapp.entity.UsersEntity;
import org.crm.gymapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public List<UsersEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public List<UserDTO> convertToUserDTO(List<UsersEntity> users) {
        return users.stream()
                .map(user -> new UserDTO(user.getId(), user.getUsername(), user.getLastname(), convertSubscriptions(user.getUserSubscriptions())))
                .collect(Collectors.toList());
    }

    private Set<SubscriptionDTO> convertSubscriptions(Set<SubscriptionsEntity> subscriptions) {
        return subscriptions.stream()
                .map(sub -> new SubscriptionDTO(sub.getId(), sub.getSubType().getType(), sub.getPrice(), sub.isCoach(), sub.isActive()))
                .collect(Collectors.toSet());
    }
}
