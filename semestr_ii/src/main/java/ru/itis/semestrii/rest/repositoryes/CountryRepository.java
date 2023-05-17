package ru.itis.semestrii.rest.repositoryes;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.itis.semestrii.rest.model.Country;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Long> {

    Country findByAlpha3(String alpha3);

    @Query("select c from Country c ")
    List<Country> getAll();

    @Query("select max(c.id) + 1 from Country c ")
    Long getNexId();
}

