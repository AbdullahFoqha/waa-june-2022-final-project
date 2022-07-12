package edu.miu.waabackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String email;
    private String firstName;
    private String lastname;
    ////adding new fields
    private String state;
    private String cityName;


    @OneToOne
    private Department major;
    private float gpa;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<JobAdvertisement> jobAdvertisement;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<AppliedJobs> appliedJobs;
}
