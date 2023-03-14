package ru.itis.lab2_5_JPA.hibernate.model.taxi;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.InheritanceType.JOINED;
import static javax.persistence.InheritanceType.TABLE_PER_CLASS;

@Getter@Setter
@Entity
@Inheritance(strategy = TABLE_PER_CLASS)
public class Person {

    @Id
    @SequenceGenerator(name="personGenId", sequenceName="person_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="personGenId")
    private Long id;

    @Column(name = "person_name")
    private String name;

    @Column(length = 15)
    private String phone;

    private String email;

}
