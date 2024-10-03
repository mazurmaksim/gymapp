package org.crm.gymapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "gym_subscriptions", uniqueConstraints = {
        @UniqueConstraint(columnNames = "sub_name")
})
public class GymSubscriptionEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "sub_type")
    private String subType;

    @Column(name = "duration_days")
    private int durationDays;

    @Column(name = "price")
    private Double price;
}
