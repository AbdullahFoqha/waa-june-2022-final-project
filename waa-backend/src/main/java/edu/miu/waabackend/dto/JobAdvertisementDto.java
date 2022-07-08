package edu.miu.waabackend.dto;

import edu.miu.waabackend.domain.Student;
import edu.miu.waabackend.domain.Tag;
import lombok.Data;

import java.io.File;
import java.util.List;

@Data
public class JobAdvertisementDto implements DTOEntity{
    private List<Tag> tags;
    private String description;
    private String benefits;
    private List<File> files;
    private Student student;
}
