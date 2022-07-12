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
    @OneToOne
    private Tag tag;
    private String description;
    private String benefits;
    //adding new fields
    private String stateName;
    private String cityName;
    private String companyName;

    //private List<File> files;
    @ManyToOne
    @JoinColumn
    private Student student;
}
