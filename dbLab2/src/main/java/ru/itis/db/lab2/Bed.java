package ru.itis.db.lab2;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Bed {
    private Room room;
    private String bedNumber;
    private float price;

    public String toJSON() {
        return
                "{\"room\":" + room.toJSON() + "," +
                        "\"bedNumber\":\"" + bedNumber + "\"," +
                        "\"price\":" + price + "}";
    }
}
