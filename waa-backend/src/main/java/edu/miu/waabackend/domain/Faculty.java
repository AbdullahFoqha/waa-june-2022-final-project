package edu.miu.waabackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Faculty {
    @Id
    private String userId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String email;
    private String firstName;
    private String lastName;

    @OneToOne()
    private Department department;

    @OneToMany(mappedBy = "faculty")
    @JsonIgnore
    private List<Comments> comments;
}
