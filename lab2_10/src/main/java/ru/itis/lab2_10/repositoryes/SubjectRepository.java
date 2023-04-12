package ru.itis.lab2_10.repositoryes;

import org.springframework.data.repository.CrudRepository;
import ru.itis.lab2_10.model.Subject;

public interface SubjectRepository extends CrudRepository<Subject, Long> {

}
