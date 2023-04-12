package ru.itis.lab2_10.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter@Setter
public class Groupp {
    @Id
    @SequenceGenerator(name = "groupGenerator", sequenceName = "groupp_seq", allocationSize = 1)
    @GeneratedValue(generator = "groupGenerator", strategy = GenerationType.SEQUENCE)
    private Long id;

    String name;

}
