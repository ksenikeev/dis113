package semestrii.gui.repositoryes;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import semestrii.gui.model.Country;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Long> {

    Country findByAlpha3(String alpha3);

    @Query("select c from Country c ")
    List<Country> getAll();

    @Query("select max(c.id) + 1 from Country c ")
    Long getNexId();

    @Query(value = "select * from country order by :orderingField limit :pageSize offset (:pageNumber - 1) * :pageSize ", nativeQuery = true)
    List<Country> getAllByPage(
            @Param("pageSize") Integer pageSize,
            @Param("pageNumber") Integer pageNumber,
            @Param("orderingField") String orderingField);

    @Query("select c from Country c ")
    List<Country> getAllByPage(Pageable pageable);

}

