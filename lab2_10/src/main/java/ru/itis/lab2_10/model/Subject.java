package ru.itis.lab2_10.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter@Setter
public class Subject {
    @Id
    @SequenceGenerator(name = "subjectGenerator", sequenceName = "subject_seq", allocationSize = 1)
    @GeneratedValue(generator = "subjectGenerator", strategy = GenerationType.SEQUENCE)
    private Long id;

    String name;

}
