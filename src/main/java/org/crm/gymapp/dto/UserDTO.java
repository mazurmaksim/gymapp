package org.crm.gymapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private LocalDateTime regDate;
    private String email;
    private String phoneNumber;
    private String socialMedia;

}