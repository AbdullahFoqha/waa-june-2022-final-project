package edu.miu.waabackend.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Student extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String email;
    private String firstName;
    private String lastname;

    @OneToOne
    private Department major;
    private float gpa;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "student")
    private List<JobAdvertisement> jobAdvertisement;

    @OneToMany(mappedBy = "student")
    private List<AppliedJobs> appliedJobs;

    public Student(String email, String password, String firstName, String lastname, Department major, float gpa) {
        super(password, LocalDateTime.now(), true);
        this.email = email;
        this.firstName = firstName;
        this.lastname = lastname;
        this.major = major;
        this.gpa = gpa;
    }
}
