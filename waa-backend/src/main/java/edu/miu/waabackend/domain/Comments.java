package edu.miu.waabackend.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String comment;

    @ManyToOne
    @JoinColumn
    private Faculty faculty;

    @ManyToOne
    @JoinColumn
    private Student student;
}
