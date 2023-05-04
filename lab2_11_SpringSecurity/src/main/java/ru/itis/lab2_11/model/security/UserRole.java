package ru.itis.lab2_11.model.security;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="dict_userrole")
@Getter@Setter
public class UserRole {

    @Id
    private Long id;
    private String name;
}
