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
    private String state;
    private String cityName;
    private float gpa;

    @OneToOne
    private Department major;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<JobAdvertisement> jobAdvertisement;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<AppliedJobs> appliedJobs;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<Comments> comments;
}
