package org.crm.gymapp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.crm.gymapp.entity.security.StaffUsers;
import org.crm.gymapp.model.SubscriptionTypes;
import org.hibernate.annotations.GenericGenerator;

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

    @ManyToMany(mappedBy = "userSubscriptions", fetch = FetchType.LAZY)
    @JsonBackReference
    Set<UsersEntity> userEntity;

}
