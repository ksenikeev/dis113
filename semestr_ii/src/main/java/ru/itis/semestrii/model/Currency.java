package ru.itis.semestrii.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
public class Currency extends AbstractDict {
    private String code3;
    @Column(length = 512)
    private String country;
    private String info;
}
