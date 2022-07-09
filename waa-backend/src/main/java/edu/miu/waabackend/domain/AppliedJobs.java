package edu.miu.waabackend.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class AppliedJobs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @OneToOne()
    @JoinColumn(name = "job_fk")
    private JobAdvertisement job;
    private int count;
    @ManyToOne
    @JoinColumn
    private Student student;
}
