package ru.itis.lab2_6.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
@Entity
public class TaxiCompany extends AbstractEntity {
    @Id
    @SequenceGenerator(name="companyGenId", sequenceName="taxicompany_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="companyGenId")
    private Long id;

    private String name;

    @OneToMany
    private List<Driver> drivers;
}
