package org.crm.gymapp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
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
@Table(name = "users")
public class UsersEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "name")
    private String username;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "reg_date")
    private LocalDateTime regDate;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "social_media")
    private String socialMedia;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_subscription",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "sub_id")
    )
    @JsonManagedReference
    private Set<UserSubscriptionEntity> userSubscription;
}
