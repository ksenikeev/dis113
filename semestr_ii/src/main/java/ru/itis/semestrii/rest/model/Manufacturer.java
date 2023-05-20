package ru.itis.semestrii.rest.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Список товаров
 * 1. формируется на стороне клиента (страны)
 * 2. Отправляется на центральную площадку (name, units, innerUID)
 * 3. Остальные площадки должны периодически запрашивать новые товары
 * из центральной площадки (все / начиная с некоторого времени)
 */
@Getter@Setter
@Entity
public class Manufacturer {
    @Id
    @SequenceGenerator(name = "manufacturerGen", sequenceName = "manufacturer_seq", allocationSize = 1)
    @GeneratedValue(generator = "manufacturerGen", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String uid;
    @Column(length = 512)
    private String name;
    private String country;
    @Column(length = 512)
    private String address;

}
