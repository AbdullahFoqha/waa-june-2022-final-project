package edu.miu.waabackend.dto;

import edu.miu.waabackend.domain.Faculty;
import lombok.Data;

@Data
public class CommentsDto implements DTOEntity {
    private Long Id;
    private String comment;
    private Faculty faculty;
    private Long student_Id;
}
