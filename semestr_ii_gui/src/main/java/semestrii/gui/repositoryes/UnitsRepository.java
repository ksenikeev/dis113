package semestrii.gui.repositoryes;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import semestrii.gui.model.Units;

import java.util.List;

public interface UnitsRepository extends CrudRepository<Units, Long> {

    Units findByCode(String code);

    @Query("select u from Units u ")
    List<Units> getAll();

}

