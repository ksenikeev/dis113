package ru.itis.lab2_10.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import ru.itis.lab2_10.model.Exam;
import ru.itis.lab2_10.model.Groupp;
import ru.itis.lab2_10.model.Student;
import ru.itis.lab2_10.model.Subject;
import ru.itis.lab2_10.repositoryes.ExamRepository;
import ru.itis.lab2_10.repositoryes.SubjectRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExamService {

    @Autowired
    private ExamRepository repository;

    public Iterable<Exam> findAll() {
        return  repository.findAll();
    }

    public Optional<Exam> findById(Long id) {
        return repository.findById(id);
    }

    public List<Exam> findByStudent(Student student) {
        return repository.findByStudent(student);
    }

    public List<Exam> findByGroupp(Groupp groupp) {
        return repository.findByGroupp(groupp);
    }

}
