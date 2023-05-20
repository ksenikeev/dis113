package ru.itis.semestrii.rest.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.itis.semestrii.rest.model.Country;

import java.util.Date;

@Getter@Setter@ToString
public class SellDto {
    private Long id;
    private ProductDto product;
    private double price;
    private String currency;
    private double quantity;
    private ManufacturerDto manufacturer;
    private Date  date;
}
