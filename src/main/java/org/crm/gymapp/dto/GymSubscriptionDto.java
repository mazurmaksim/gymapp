package org.crm.gymapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.crm.gymapp.entity.GymSubscriptionEntity;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link GymSubscriptionEntity}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GymSubscriptionDto implements Serializable {
   private UUID id;
   private String subType;
   private int durationDays;
   private Double price;
}