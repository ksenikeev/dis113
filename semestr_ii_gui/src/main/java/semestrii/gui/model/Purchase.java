package semestrii.gui.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Покупка
 */
@Getter
@Setter
@Entity
public class Purchase {

    @Id
    @SequenceGenerator(name = "purchaseGen", sequenceName = "purchase_seq", allocationSize = 1)
    @GeneratedValue(generator = "purchaseGen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private Sell sell;

    /**  UID код генерируется при создании покупки  */
    private String uid;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime purchaseDate;

    /**  Покупатель  */
    @ManyToOne
    private Manufacturer manufacturer;

}
