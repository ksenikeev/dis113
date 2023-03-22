package ru.itis.lab2_6.model;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity {
    abstract public Long getId();
}
