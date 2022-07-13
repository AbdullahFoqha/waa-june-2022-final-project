package edu.miu.waabackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FacultyDto implements DTOEntity {
    private Long Id;
    private String email;
    private String firstName;
    private String lastName;
    private String userId;
    private String password;
    private DepartmentDto department;
}
