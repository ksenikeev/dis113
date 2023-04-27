package ru.itis.lab2_10.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.lab2_10.dto.StudentDto;
import ru.itis.lab2_10.model.Groupp;
import ru.itis.lab2_10.model.Student;
import ru.itis.lab2_10.model.Subject;
import ru.itis.lab2_10.repositoryes.GrouppRepository;
import ru.itis.lab2_10.repositoryes.StudentRepository;
import ru.itis.lab2_10.repositoryes.SubjectRepository;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private GrouppRepository grouppRepository;

    public Iterable<Student> findAll() {
        return  repository.findAll();
    }

    public Optional<Student> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Student save(StudentDto studentDto) {
        Student student = new Student();

        Groupp groupp = grouppRepository.findById(studentDto.getGroupp()).get();

        student.setGroupp(groupp);
        student.setName(studentDto.getStudent());

        return repository.save(student);
    }

}
