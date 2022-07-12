package edu.miu.waabackend.dto;

import edu.miu.waabackend.domain.JobAdvertisement;
import edu.miu.waabackend.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AppliedJobDto implements DTOEntity {
    private Long Id;
    private JobAdvertisement job;
    private int count;
    private Student student;
}
