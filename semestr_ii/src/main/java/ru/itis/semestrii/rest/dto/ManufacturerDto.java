package ru.itis.semestrii.rest.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.itis.semestrii.rest.model.Country;

@Getter@Setter@ToString
public class ManufacturerDto {
    private String uid;
    private String name;
    private String country;
    private String address;
}
