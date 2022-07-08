package edu.miu.waabackend.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class JobHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private List<Tag> tags;
    private String companyName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String reasonToLeave;
    private String comments;
}
