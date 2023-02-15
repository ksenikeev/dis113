package ru.itis.semestr2.model;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class TripStatus {
    private Integer id;
    private String name;

    public TripStatus() {}

    public TripStatus(String name) {
        this.name = name;
    }
}
