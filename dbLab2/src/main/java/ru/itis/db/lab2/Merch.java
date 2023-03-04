package ru.itis.db.lab2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor
public class Merch {
    private String artikul;
    private String name;
    private Float price;
    private Store store;
    private Integer count;
}
