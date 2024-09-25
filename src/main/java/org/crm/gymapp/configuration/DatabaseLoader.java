package org.crm.gymapp.configuration;

import org.crm.gymapp.entity.security.Role;
import org.crm.gymapp.entity.security.StaffUsers;
import org.crm.gymapp.repository.RoleRepository;
import org.crm.gymapp.repository.StaffUsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

//@Configuration
public class DatabaseLoader {
//    @Bean
//    CommandLineRunner init(StaffUsersRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
//        return args -> {
//            Role staffRole = new Role();
//            staffRole.setName("USER");
//            roleRepository.save(staffRole);
//
//            StaffUsers user = new StaffUsers();
//            user.setUsername("user1@gmail.com");
//            user.setPassword(passwordEncoder.encode("123"));
//            user.setEnabled(true);
//            user.setRoles(Set.of(staffRole));
//            userRepository.save(user);
//
//        };
//    }
}
