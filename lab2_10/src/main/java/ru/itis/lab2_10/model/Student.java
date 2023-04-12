package ru.itis.lab2_10.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter@Setter
public class Student {
    @Id
    @SequenceGenerator(name = "studentGenerator", sequenceName = "student_seq", allocationSize = 1)
    @GeneratedValue(generator = "studentGenerator", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @ManyToOne
    private Groupp groupp;

}
