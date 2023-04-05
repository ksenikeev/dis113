package ru.itis.lab2_8.repository;

import org.springframework.data.repository.CrudRepository;
import ru.itis.lab2_8.model.AccessProtocol;
import java.util.List;

public interface AccessProtocolRepository
        extends CrudRepository<AccessProtocol, Long> {
    List<AccessProtocol> findByUsernameOrSuccess(String username, Boolean success);

}
