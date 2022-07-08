package edu.miu.waabackend.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto implements DTOEntity{
    private String password;
    private LocalDateTime LastLoggedInAt;
    private boolean active;
}
