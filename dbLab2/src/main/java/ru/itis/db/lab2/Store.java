package ru.itis.db.lab2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor
public class Store {
    private Market market;
    private String address;
}
