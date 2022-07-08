package edu.miu.waabackend.dto;

import edu.miu.waabackend.domain.JobAdvertisement;
import edu.miu.waabackend.domain.Student;
import lombok.Data;

@Data
public class AppliedJobDto implements DTOEntity {
    private JobAdvertisement job;
    private int count;
    private Student student;
}
