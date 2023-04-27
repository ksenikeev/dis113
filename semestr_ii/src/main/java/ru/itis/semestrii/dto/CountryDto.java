package ru.itis.semestrii.dto;

import lombok.Getter;
import lombok.Setter;
import ru.itis.semestrii.model.Country;

@Getter@Setter
public class CountryDto {
    private Long id;
    private String code;
    private String name;
    private String alpha3;
    private String currency;

    public CountryDto(Country country) {
        this.id = country.getId();
        this.code = country.getCode();
        this.name = country.getName();
        this.alpha3 = country.getAlpha3();
        this.currency = country.getCurrency();
    }
}
