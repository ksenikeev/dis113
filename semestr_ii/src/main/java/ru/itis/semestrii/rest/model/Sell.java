package ru.itis.semestrii.rest.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.itis.semestrii.rest.dto.ProductDto;

/**
 * Список товаров
 * 1. формируется на стороне клиента (страны)
 * 2. Отправляется на центральную площадку (name, units, innerUID)
 * 3. Остальные площадки должны периодически запрашивать новые товары
 * из центральной площадки (все / начиная с некоторого времени)
 */
@Getter@Setter
@Entity
public class Sell {
    @Id
    @SequenceGenerator(name = "sellGen", sequenceName = "sell_seq", allocationSize = 1)
    @GeneratedValue(generator = "sellGen", strategy = GenerationType.SEQUENCE)
    private Long id;
    private Product product;
    private Double price;


   @ManyToOne
    private Currency currency;
    private Double quantity;
    @ManyToOne
    private Country country;

    private Boolean isSelled;


}
