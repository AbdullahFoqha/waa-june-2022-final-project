package edu.miu.waabackend.dto;

import edu.miu.waabackend.domain.Faculty;
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
    private Faculty faculty;
    private Long student_Id;
}
