package ru.itis.semestr2.model;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class UserRole {
    private Integer id;
    private String name;

    public UserRole(Integer id) {
        this.id = id;
    }
}
