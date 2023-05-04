package ru.itis.semestrii.repositoryes;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.itis.semestrii.model.Currency;
import ru.itis.semestrii.model.Units;

import java.util.List;

public interface UnitsRepository extends CrudRepository<Units, Long> {

    Units findByCode(String code);

    @Query("select u from Units u ")
    List<Units> getAll();

}

