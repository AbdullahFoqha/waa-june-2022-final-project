package edu.miu.waabackend.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Student extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String email;
    private String firstName;
    private String lastname;
    private Department major;
    private float gpa;

    public Student(Long id, String email, String password, String firstName, String lastname, Department major, float gpa) {
        super(password, LocalDateTime.now(), true);
        Id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastname = lastname;
        this.major = major;
        this.gpa = gpa;
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

    public Department getMajor() {
        return major;
    }

    public float getGpa() {
        return gpa;
    }
}
