package ru.itis.db.lab2;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Booking {
    private Hotel hotel;
    private Room room;
    private Bed bed;
    private Client client;
    private String arrivalDate;
    private String stayingDate;
    private float summ;

    public String toJSON() {
        return
                "{\"hotel\":" + hotel.toJSON() + "," +
                        "\"room\":" + room.toJSON() + "," +
                        (bed != null ? ("\"bed\":" + bed.toJSON() + ",") : "")
                         +
                        "\"client\":" + client.toJSON() + "," +
                        "\"arrivalDate\":\"" + arrivalDate + "\"," +
                        "\"stayingDate\":\"" + stayingDate + "\"," +
                        "\"summ\":" + summ + "}";
    }
}

