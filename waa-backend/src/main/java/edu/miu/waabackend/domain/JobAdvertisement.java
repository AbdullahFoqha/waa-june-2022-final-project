package edu.miu.waabackend.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.File;
import java.util.List;

@Entity
@Data
public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String description;
    private String benefits;
    private String companyName;

    //private List<File> files;
    @OneToOne
    private Tag tag;

    @OneToOne
    private State state;

    @OneToOne
    private City city;

    @ManyToOne
    @JoinColumn
    private Student student;
}
