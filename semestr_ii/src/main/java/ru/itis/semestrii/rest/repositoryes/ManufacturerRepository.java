package ru.itis.semestrii.rest.repositoryes;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.itis.semestrii.rest.dto.ManufacturerDto;
import ru.itis.semestrii.rest.model.Country;
import ru.itis.semestrii.rest.model.Manufacturer;

import java.util.List;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long> {

    Manufacturer findByUid(String uid);

    @Query("select m from Manufacturer m ")
    List<Manufacturer> getAll();

}

