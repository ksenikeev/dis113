package ru.itis.semestrii.model;


import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@MappedSuperclass
public class AbstractDict {
    @Id
    private Long id;
    private String code;
    private String name;
    private String fullName;
}
