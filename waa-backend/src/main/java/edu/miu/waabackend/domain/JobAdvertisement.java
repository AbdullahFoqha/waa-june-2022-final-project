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
    private List<Tag> tags;
    private String description;
    private String benefits;
    private List<File> files;
    @ManyToOne
    @JoinColumn
    private Student student;
}
