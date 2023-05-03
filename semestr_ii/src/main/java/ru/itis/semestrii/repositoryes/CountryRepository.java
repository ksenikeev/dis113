package ru.itis.semestrii.repositoryes;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.itis.semestrii.model.Country;
import ru.itis.semestrii.model.Currency;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Long> {

    Country findByAlpha3(String alpha3);

    @Query("select c from Country c ")
    List<Country> getAll();

    @Query("select max(c.id) + 1 from Country c ")
    Long getNexId();
}

