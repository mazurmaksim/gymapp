package org.crm.gymapp.service;

import org.crm.gymapp.entity.security.StaffUsers;
import org.crm.gymapp.repository.StaffUsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserStaffService {
    private final StaffUsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    public UserStaffService(StaffUsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public StaffUsers saveUser(StaffUsers user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return usersRepository.save(user);
    }
}
