package edu.miu.waabackend.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Faculty extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String email;
    private String firstName;
    private String lastname;
    private Department department;

    public Faculty(Long id, String email, String password, String firstName, String lastname, Department department) {
        super(password, LocalDateTime.now(), true);
        Id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastname = lastname;
        this.department = department;
    }

    @Override
    public Long getId() {
        return Id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public Department getDepartment() {
        return department;
    }
}
