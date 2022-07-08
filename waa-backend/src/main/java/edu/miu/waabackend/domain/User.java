package edu.miu.waabackend.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String password;
    private LocalDateTime LastLoggedInAt;
    private boolean active;

    public User() {}
    public User(String password, LocalDateTime lastLoggedInAt, boolean active) {
        this.password = password;
        this.LastLoggedInAt = lastLoggedInAt;
        this.active = active;
    }
}
