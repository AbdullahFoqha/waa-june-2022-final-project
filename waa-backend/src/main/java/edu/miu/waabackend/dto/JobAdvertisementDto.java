package edu.miu.waabackend.dto;

import edu.miu.waabackend.domain.City;
import edu.miu.waabackend.domain.State;
import edu.miu.waabackend.domain.Student;
import edu.miu.waabackend.domain.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.File;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JobAdvertisementDto implements DTOEntity {
    private Long Id;
    private String description;
    private String benefits;
    //private List<File> files;
    private String companyName;
    private Tag tag;
    private State state;
    private City city;
    private Student student;
}
