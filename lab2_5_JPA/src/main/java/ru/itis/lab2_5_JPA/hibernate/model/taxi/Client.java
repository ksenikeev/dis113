package ru.itis.lab2_5_JPA.hibernate.model.taxi;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter@Setter
@Entity
public class Client extends Person {

    @Id
    private Long id;
}
