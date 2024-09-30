package org.crm.gymapp.repository;

import org.crm.gymapp.entity.CoachEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CoachRepository extends JpaRepository<CoachEntity, UUID> {
}
