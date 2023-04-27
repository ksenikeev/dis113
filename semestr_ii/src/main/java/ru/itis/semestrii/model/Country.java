package ru.itis.semestrii.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
public class Country extends AbstractDict {
    private String alpha2;
    private String alpha3;
    private String currency;
}
