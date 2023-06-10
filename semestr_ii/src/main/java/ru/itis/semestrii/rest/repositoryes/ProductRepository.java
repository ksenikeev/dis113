package ru.itis.semestrii.rest.repositoryes;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.itis.semestrii.rest.model.Product;
import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    Product findByInnerUID(String innerUID);

    @Query("select u from Product u ")
    List<Product> getAll();

    @Query("select p from Product p where p.createTime >= :time ")
    List<Product> getAllAfterDate(@Param("time") LocalDateTime time);


}

