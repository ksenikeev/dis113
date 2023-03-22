package ru.itis.lab2_6.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.InheritanceType.TABLE_PER_CLASS;

@Getter@Setter
@MappedSuperclass
public abstract class Person extends AbstractEntity {

    @Id
    @SequenceGenerator(name="personGenId", sequenceName="person_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="personGenId")
    protected Long id;

    @Column(name = "person_name")
    protected String name;

    @Column(length = 15)
    protected String phone;

    protected String email;

}
