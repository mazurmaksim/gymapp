package org.crm.gymapp.repository;

import org.crm.gymapp.entity.UsersEntity;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends Repository<UsersEntity, UUID> {
    UsersEntity findByUsername(String username);
    UsersEntity findById(UUID uuid);
    void save(UsersEntity usersEntity);
    List<UsersEntity> findAll();
    void delete(UsersEntity usersEntity);

}
