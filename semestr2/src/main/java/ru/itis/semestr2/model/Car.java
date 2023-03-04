package ru.itis.semestr2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@NoArgsConstructor
public class Car {
    private Integer id;
    private String carNumber;
    private String carBrand;
    private String color;

    public Car(String carNumber, String carBrand, String color) {
        this.carNumber = carNumber;
        this.carBrand = carBrand;
        this.color = color;
    }
}
