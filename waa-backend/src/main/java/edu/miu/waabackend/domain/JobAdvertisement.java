package edu.miu.waabackend.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
}
