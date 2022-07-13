package edu.miu.waabackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommentsDto implements DTOEntity {
    private Long Id;
    private String comment;
    private FacultyDto faculty;
    private StudentDto student;
}
