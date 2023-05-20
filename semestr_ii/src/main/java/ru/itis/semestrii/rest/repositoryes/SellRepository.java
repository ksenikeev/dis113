package ru.itis.semestrii.rest.repositoryes;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.itis.semestrii.rest.model.Country;
import ru.itis.semestrii.rest.model.Product;
import ru.itis.semestrii.rest.model.Sell;

import java.util.List;

public interface SellRepository extends CrudRepository<Sell, Long> {

    List<Sell> findByProduct(Product product);
    List<Sell> findByProductWhereIsSelledIsTrue(Product product);
    @Query("select s from Sell s where product=:product and isSelled=false")
    List<Sell> findByNotSelledProduct(@Param("product")Product product);
    @Query("select s from Sell s ")
    List<Sell> getAll();

}

