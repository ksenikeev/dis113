package ru.itis.lab2_10.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter@Setter
public class Exam {
    @Id
    @SequenceGenerator(name = "examGenerator", sequenceName = "exam_seq", allocationSize = 1)
    @GeneratedValue(generator = "examGenerator", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private Subject subject;

    @ManyToOne
    private Student student;

    @Temporal(TemporalType.DATE)
    private Date examDate;

    private Integer score;
}
