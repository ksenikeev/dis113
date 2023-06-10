package semestrii.gui.model;


import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 * Абстрактный класс - предок для справочников, содержит общий для справочников набор полей
 */
@Getter@Setter
@MappedSuperclass
public abstract class AbstractDict {
    @Id
    private Long id;
    private String code;
    private String name;
    private String fullName;
}
