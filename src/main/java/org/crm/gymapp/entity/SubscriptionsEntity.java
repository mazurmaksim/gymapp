package org.crm.gymapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.crm.gymapp.model.SubscriptionTypes;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SubscriptionsEntity {

    @Id
    private int id;

    @Column(name = "sub_type")
    private SubscriptionTypes subType;

    @Column(name = "price")
    private double price;

    @Column(name = "coach")
    private boolean coach;
}
