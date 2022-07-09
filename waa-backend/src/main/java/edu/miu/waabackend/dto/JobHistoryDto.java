package edu.miu.waabackend.dto;

import edu.miu.waabackend.domain.Tag;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class JobHistoryDto implements DTOEntity {
    private Long Id;
    private Tag tag;
    private String companyName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String reasonToLeave;
    private String comments;
}
