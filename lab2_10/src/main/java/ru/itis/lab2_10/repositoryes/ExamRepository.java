package ru.itis.lab2_10.repositoryes;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.itis.lab2_10.model.Exam;
import ru.itis.lab2_10.model.Groupp;
import ru.itis.lab2_10.model.Student;
import ru.itis.lab2_10.model.Subject;

import java.util.List;

public interface ExamRepository extends CrudRepository<Exam, Long> {
    List<Exam> findByStudent(Student student);

    @Query("select e from Exam e where e.student.groupp = :groupp ")
    List<Exam> findByGroupp(@Param("groupp") Groupp groupp);
}
