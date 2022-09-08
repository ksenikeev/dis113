package ru.itis.db.lab2;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Room {
    private Hotel hotel;
    private String roomNumber;
    private String category;
    private float price;

    public String toJSON() {
        return
                "{\"hotel\":" + hotel.toJSON() + "," +
                        "\"roomNumber\":\"" + roomNumber + "\"," +
                        "\"category\":\"" + category + "\"," +
                        "\"price\":" + price + "}";

    }
}
