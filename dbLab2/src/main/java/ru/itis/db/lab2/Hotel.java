package ru.itis.db.lab2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hotel {
    private String name;
    private String address;
    private String category;

    public String toJSON() {
        return
                "{\"name\":\"" + name + "\"," +
                        "\"address\":\"" + address + "\"," +
                        "\"category\":\"" + category + "\"}";

    }
}
