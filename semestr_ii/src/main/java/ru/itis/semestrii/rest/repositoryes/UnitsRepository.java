package ru.itis.semestrii.rest.repositoryes;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.itis.semestrii.rest.model.Units;

import java.util.List;

public interface UnitsRepository extends CrudRepository<Units, Long> {

    Units findByCode(String code);

    @Query("select u from Units u ")
    List<Units> getAll();

}

