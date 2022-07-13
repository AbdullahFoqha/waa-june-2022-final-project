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
    private float gpa;
    private String email;
    private String firstName;
    private String lastName;
    private String state;
    private String cityName;
    private String userId;

    @OneToOne
    private Department major;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<JobAdvertisement> jobAdvertisement;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<Comments> comments;
}
