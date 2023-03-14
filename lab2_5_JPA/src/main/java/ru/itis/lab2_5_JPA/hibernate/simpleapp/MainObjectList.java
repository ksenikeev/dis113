package ru.itis.lab2_5_JPA.hibernate.simpleapp;

import ru.itis.lab2_5_JPA.hibernate.model.univer.Student;

import javax.persistence.*;
import java.util.List;

public class MainObjectList {
    public static void main(String[] args) {
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("lab2_5");

        EntityManager entityManager = emf.createEntityManager();

        Query query = entityManager.createQuery("select s from Student s ");

        List<Student> students = query.getResultList();

        students.forEach(student -> {
            System.out.println(student.getId() + ", " + student.getName()
                    + ", " + student.getGroupp().getName());
        });

        entityManager.close();
        emf.close();

    }
}
