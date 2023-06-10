package semestrii.gui.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
public class CurrencyDto {
    private Long id;
    private String code;
    private String name;
    private String code3;
    /** Country code */
    private String alpha3;
    private String info;
}
