package org.crm.gymapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class UsersEntity {
    @Id
    private UUID id;

    @Column(name = "name")
    private String username;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "reg_date")
    private LocalDateTime regDate;

//    @Column(name = "email")
//    private String email;
//
//    @Column(name = "phone_number")
//    private String phoneNumber;
//
//    @Column(name = "social_media")
//    private String socialMedia;
}
