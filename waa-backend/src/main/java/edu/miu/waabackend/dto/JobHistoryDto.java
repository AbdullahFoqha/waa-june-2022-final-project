package edu.miu.waabackend.dto;

import edu.miu.waabackend.domain.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JobHistoryDto implements DTOEntity {
    private Long Id;
    private Tag tag;
    private String companyName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String reasonToLeave;
    private String comments;
}
