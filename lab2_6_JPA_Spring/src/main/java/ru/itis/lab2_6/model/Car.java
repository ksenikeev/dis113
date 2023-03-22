package ru.itis.lab2_6.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
public class Car extends AbstractEntity {

    @Id
    @SequenceGenerator(name="carGenId", sequenceName="car_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="carGenId")
    private Long id;

    private String carNumber;

    @Enumerated(EnumType.STRING)
    private CarModel carModel;
}
