package semestrii.gui.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import semestrii.gui.model.Country;

@Getter@Setter@ToString
public class CountryDto {
    private Long id;
    private String code;
    private String name;
    private String alpha3;
    private String currency;

    public CountryDto() {}

    public CountryDto(Country country) {
        this.id = country.getId();
        this.code = country.getCode();
        this.name = country.getName();
        this.alpha3 = country.getAlpha3();
        this.currency = country.getCurrency();
    }
}
