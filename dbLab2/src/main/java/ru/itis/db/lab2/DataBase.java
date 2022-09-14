package ru.itis.db.lab2;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter@Setter
@XmlRootElement
public class DataBase {
    private List<Basket> baskets;
}
