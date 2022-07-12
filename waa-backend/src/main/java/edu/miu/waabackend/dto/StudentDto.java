package edu.miu.waabackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.miu.waabackend.domain.Comments;
import edu.miu.waabackend.domain.Department;
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
    private String firstName;
    private String lastname;
    private DepartmentDto major;
    private List<CommentsDto> comments;
}
