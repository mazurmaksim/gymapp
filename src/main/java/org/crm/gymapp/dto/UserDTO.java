package org.crm.gymapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.crm.gymapp.entity.UsersEntity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime regDate;
    private String email;
    private String phoneNumber;
    private String socialMedia;
    private Set<SubscriptionDTO> subscriptions;

    public UserDTO(UUID id, String username, String lastname, Set<SubscriptionDTO> subscriptionDTOS) {
        this.id = id;
        this.username = username;
        this.lastname = lastname;
        this.subscriptions = subscriptionDTOS;
    }
}