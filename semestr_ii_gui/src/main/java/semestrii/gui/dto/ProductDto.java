package semestrii.gui.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class ProductDto {
    private String name;
    private String unitsCode;
    private String innerUID;

    public String toJSON() {
        return
        "{\"name\":\"" + name + "\",\"unitsCode\":\"" + unitsCode + "\",\"innerUID\":\"" + innerUID + "\"}";
    }
}
