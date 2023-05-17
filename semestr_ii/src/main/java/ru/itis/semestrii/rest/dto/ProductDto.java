package ru.itis.semestrii.rest.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDto {
    private String name;
    private String unitsCode;
    private String innerUID;
}
