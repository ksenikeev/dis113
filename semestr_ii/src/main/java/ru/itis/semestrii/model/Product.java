package ru.itis.semestrii.model;
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
public class Product {
    @Id
    @SequenceGenerator(name = "productGen", sequenceName = "product_seq", allocationSize = 1)
    @GeneratedValue(generator = "productGen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 512)
    private String name;

    @ManyToOne
    private Units units;

    @Column(unique = true)
    private String innerUID;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createTime;
}
