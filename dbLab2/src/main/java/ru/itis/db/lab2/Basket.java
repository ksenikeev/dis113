package ru.itis.db.lab2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter@AllArgsConstructor
public class Basket {
    private Client client;
    private String createDate;
    private String payDate;
    private List<Merch> merches;
    private Float summ;
}
