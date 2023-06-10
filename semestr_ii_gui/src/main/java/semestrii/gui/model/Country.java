package semestrii.gui.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * Справочник стран
 * alpha3 - международный код страны
 */
@Getter@Setter
@Entity
public class Country extends AbstractDict {
    private String alpha2;
    private String alpha3;
    private String currency;
}
