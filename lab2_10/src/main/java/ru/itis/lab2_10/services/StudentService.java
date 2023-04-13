package ru.itis.lab2_10.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.lab2_10.model.Student;
import ru.itis.lab2_10.model.Subject;
import ru.itis.lab2_10.repositoryes.StudentRepository;
import ru.itis.lab2_10.repositoryes.SubjectRepository;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Iterable<Student> findAll() {
        return  repository.findAll();
    }

    public Optional<Student> findById(Long id) {
        return repository.findById(id);
    }

}
