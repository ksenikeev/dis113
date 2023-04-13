package ru.itis.lab2_10.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.lab2_10.model.Groupp;
import ru.itis.lab2_10.model.Subject;
import ru.itis.lab2_10.repositoryes.GrouppRepository;
import ru.itis.lab2_10.repositoryes.SubjectRepository;

import java.util.Optional;

@Service
public class GrouppService {

    @Autowired
    private GrouppRepository repository;

    public Iterable<Groupp> findAll() {
        return  repository.findAll();
    }

    public Optional<Groupp> findById(Long id) {
        return repository.findById(id);
    }

}
