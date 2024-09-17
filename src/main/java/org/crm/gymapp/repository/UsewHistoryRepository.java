package org.crm.gymapp.repository;

import org.crm.gymapp.entity.UserHistoryEntity;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.UUID;

public interface UsewHistoryRepository extends Repository<UserHistoryEntity, UUID> {
    UserHistoryEntity findById(UUID id);
    void save(UserHistoryEntity userHistoryEntity);
    List<UserHistoryEntity> findAll();
}
