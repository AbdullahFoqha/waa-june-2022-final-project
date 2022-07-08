package edu.miu.waabackend.dto;

import edu.miu.waabackend.domain.Department;
import lombok.Data;

@Data
public class FacultyDto implements DTOEntity {
    private Long Id;
    private String email;
    private String firstName;
    private String lastname;
    private Department department;
}
