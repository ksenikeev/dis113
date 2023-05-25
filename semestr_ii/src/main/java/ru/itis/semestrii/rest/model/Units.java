package ru.itis.semestrii.rest.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * Справочник единиц измерения (м, кг, ...)
 * Все поля наследуются от AbstractDict
 */
@Getter@Setter
@Entity
public class Units extends AbstractDict {
}
