package ru.itis.lab2_5_JPA.hibernate.simpleapp;

import ru.itis.lab2_5_JPA.hibernate.model.univer.Student;

import javax.persistence.*;

public class MainUpdateObject {
    public static void main(String[] args) {
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("lab2_5");

        EntityManager entityManager = emf.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Query query = entityManager.createQuery("select s from Student s where id = :id ", Student.class);
        query.setParameter("id", 1l);

        Student student = (Student) query.getSingleResult();

        student.setName( student.getName().toUpperCase() );

        // UPDATE
        entityManager.merge(student);

        transaction.commit();

        entityManager.close();
        emf.close();

    }
}
