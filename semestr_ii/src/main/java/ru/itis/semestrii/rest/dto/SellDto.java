package ru.itis.semestrii.rest.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

@Getter@Setter@ToString
public class SellDto {
    private ProductDto product;
    private double price;
    /** currency code3 */
    private String currency;
    private double quantity;
    private ManufacturerDto manufacturer;
    private Date sellDate;
}
