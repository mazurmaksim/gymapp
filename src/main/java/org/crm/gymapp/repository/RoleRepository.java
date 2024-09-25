package org.crm.gymapp.repository;

import org.crm.gymapp.entity.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {

    Role save(Role role);
}
