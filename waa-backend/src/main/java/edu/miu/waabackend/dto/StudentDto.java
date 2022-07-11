package edu.miu.waabackend.dto;

import edu.miu.waabackend.domain.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentDto implements DTOEntity {
    private Long Id;
    private String email;
    private String firstName;
    private String lastname;
    private Department major;
    private float gpa;
}
