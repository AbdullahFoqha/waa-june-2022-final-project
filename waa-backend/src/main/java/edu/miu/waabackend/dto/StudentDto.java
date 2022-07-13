package edu.miu.waabackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentDto implements DTOEntity {
    private Long Id;
    private float gpa;
    private String email;
    private String password;
    private String firstName;
    private String lastname;
    private String userId;
    private String role;
    private DepartmentDto major;
    private List<CommentsDto> comments;
}
