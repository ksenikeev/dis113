package ru.itis.semestrii.repositoryes;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.itis.semestrii.model.Country;
import ru.itis.semestrii.model.Currency;

import java.util.List;

public interface CurrencyRepository extends CrudRepository<Currency, Long> {

    Currency findByCode3(String code3);

    @Query("select c from Currency c ")
    List<Currency> getAll();

}

