package ru.itis.lab2_10.repositoryes;

import org.springframework.data.repository.CrudRepository;
import ru.itis.lab2_10.model.Student;
import ru.itis.lab2_10.model.Subject;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
