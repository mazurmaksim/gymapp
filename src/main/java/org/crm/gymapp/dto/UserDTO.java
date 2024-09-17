package org.crm.gymapp.dto;

import lombok.*;
import org.crm.gymapp.entity.UsersEntity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO for {@link UsersEntity}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {
    private UUID id;
    private String username;
    private String lastname;
    private LocalDateTime regDate;
    private UUID userId;
    private String email;
    private String phoneNumber;
    private String socialMedia;

}