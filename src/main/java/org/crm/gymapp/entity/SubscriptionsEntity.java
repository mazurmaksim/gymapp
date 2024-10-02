package org.crm.gymapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.crm.gymapp.model.SubscriptionTypes;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "subscriptions")
public class SubscriptionsEntity {

    @Id
    private UUID id;

    @Column(name = "sub_type")
    @Enumerated(EnumType.STRING)
    private SubscriptionTypes subType;

    @Column(name = "price")
    private double price;

    @Column(name = "coach")
    private boolean coach;

    @Column(name = "is_active")
    private boolean active;

    @Column(name="activation_date")
    LocalDateTime activationDate;

    @ManyToMany(mappedBy = "userSubscriptions", fetch = FetchType.LAZY)
    @JsonBackReference
    Set<UsersEntity> userEntity;
}
