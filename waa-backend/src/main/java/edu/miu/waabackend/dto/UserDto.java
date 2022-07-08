package edu.miu.waabackend.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto implements DTOEntity {
    private Long Id;
    private String password;
    private LocalDateTime LastLoggedInAt;
    private boolean active;
}
