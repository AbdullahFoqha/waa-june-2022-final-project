package edu.miu.waabackend.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Faculty extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String email;
    private String firstName;
    private String lastname;
    private Department department;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "faculty")
    private List<Comments> comments;

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
