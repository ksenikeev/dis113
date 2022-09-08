package ru.itis.db.lab2;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Client {
    private String name;
    private Date birthDate;
    private String phone;
    private String email;

    public String toJSON() {
        return
                "{\"name\":\"" + name + "\"," +
                        "\"birthDate\":\"" + birthDate + "\"," +
                        "\"phone\":\"" + phone + "\"," +
                        "email\":\"" + email + "\"}";
    }
}
