package edu.miu.waabackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AppliedJobDto implements DTOEntity {
    private Long Id;
    private int count;
    private JobAdvertisementDto job;
    private String userId;
}
