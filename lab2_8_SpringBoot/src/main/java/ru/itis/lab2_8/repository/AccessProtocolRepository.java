package ru.itis.lab2_8.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.itis.lab2_8.model.AccessProtocol;

@Repository
public interface AccessProtocolRepository
        extends CrudRepository<AccessProtocol, Long> {

}
