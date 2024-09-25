package org.crm.gymapp.repository;

import org.crm.gymapp.entity.security.StaffUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StaffUsersRepository extends JpaRepository<StaffUsers, Integer> {
    Optional< StaffUsers> findByUsername(String username);
    StaffUsers save(StaffUsers user);
}
