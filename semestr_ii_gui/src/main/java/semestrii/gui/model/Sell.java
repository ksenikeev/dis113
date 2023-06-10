package semestrii.gui.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Предложение товара для продажи
 */
@Getter@Setter
@Entity
public class Sell {
    @Id
    @SequenceGenerator(name = "sellGen", sequenceName = "sell_seq", allocationSize = 1)
    @GeneratedValue(generator = "sellGen", strategy = GenerationType.SEQUENCE)
    private Long id;

    /** Товар */
    @ManyToOne
    private Product product;

    /** Цена за единицу товара */
    private Double price;

    /** Валюта, в которой товар продается */
    @ManyToOne
    private Currency currency;

    /** Количество товара для продажи */
    private Double quantity;

    @ManyToOne
    private Country country;

    /**  isSelled = True, если товар уже продан */
    private Boolean isSelled;

    /**  UID код генерируется при создании предложения  */
    private String uid;

    @Temporal(TemporalType.TIMESTAMP)
    private Date sellDate;

    @ManyToOne
    private Manufacturer manufacturer;
}
