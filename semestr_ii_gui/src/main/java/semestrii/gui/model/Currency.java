package semestrii.gui.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * Справочник валют
 */
@Getter@Setter
@Entity
public class Currency extends AbstractDict {
    private String code3;
    /** Страна, alpha3*/
    private String country;
    private String info;
}
