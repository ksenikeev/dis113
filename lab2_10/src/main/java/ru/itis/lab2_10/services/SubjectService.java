package ru.itis.lab2_10.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.lab2_10.model.Subject;
import ru.itis.lab2_10.repositoryes.SubjectRepository;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository repository;

    public Iterable<Subject> findAll() {
        return  repository.findAll();
    }

    public Optional<Subject> findById(Long id) {
        return repository.findById(id);
    }

}
