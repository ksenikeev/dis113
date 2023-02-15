package ru.itis.semestr2.model;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Driver extends User{
    private Car car;

    public Driver() {}

    public Driver(Integer id, Car car) {
        this.car = car;
        this.setId(id);
    }
}
