package ru.itis.semestrii.rest.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UnitsDto {
    private Long id;
    private String code;
    private String name;
}
