package ru.itis.db.lab2;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Db {
    private List<Booking> bookings;

    public String toJSON() {
        String res = "{\"bookings\":[";
        for (Booking booking : bookings) {
            res = res + booking.toJSON() + ",";
        }
        res = res + "]}";
        return res;
    }
}
