package edu.miu.waabackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto implements DTOEntity {
    private Long Id;
    private String password;
    private LocalDateTime LastLoggedInAt;
    private boolean active;
}
