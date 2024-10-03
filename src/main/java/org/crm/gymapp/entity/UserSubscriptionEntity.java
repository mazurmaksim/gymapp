package org.crm.gymapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "chosen_subscription")
public class UserSubscriptionEntity {

    @Id
    private UUID id;

    @Column(name = "price")
    private double userPaid;

    @Column(name = "coach")
    private boolean coach;

    @Column(name = "is_active")
    private boolean active;

    @Column(name="activation_date")
    LocalDateTime activationDate;

    @ManyToMany(mappedBy = "userSubscription", fetch = FetchType.LAZY)
    @JsonBackReference
    Set<UsersEntity> userEntity;

    @ManyToOne
    @JoinColumn(name = "sub_type", referencedColumnName = "id")
    private GymSubscriptionEntity existingSubscriptions;
}
