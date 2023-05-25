package ru.itis.semestrii.rest.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Производитель товаров для продажи на бирже
 *
 * может быть покупателем
 */
@Getter@Setter
@Entity
public class Manufacturer {
    @Id
    @SequenceGenerator(name = "manufacturerGen", sequenceName = "manufacturer_seq", allocationSize = 1)
    @GeneratedValue(generator = "manufacturerGen", strategy = GenerationType.SEQUENCE)
    private Long id;

    /**  UID код генерируется при создании производителя  innerId (for inner systems) */
    private String uid;
    @Column(length = 512)
    private String name;
    @ManyToOne
    private Country country;
    @Column(length = 512)
    private String address;
}
