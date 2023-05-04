package ru.itis.semestrii.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.itis.semestrii.model.Units;

@Getter
@Setter
@ToString
public class ProductDto {
    private String name;
    private String unitsCode;
    private String innerUID;
}
