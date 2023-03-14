package ru.itis.lab2_5_JPA.hibernate.simpleapp;

import ru.itis.lab2_5_JPA.hibernate.model.univer.Groupp;
import ru.itis.lab2_5_JPA.hibernate.model.univer.Student;

import javax.persistence.*;

public class MainSimpleUseHibernate {
    public static void main(String[] args) {
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("lab2_5");

        EntityManager entityManager = emf.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Groupp groupp = new Groupp();
        groupp.setId(1l);
        groupp.setName("11-113");

        Student student = new Student();
        //student.setId(1L);
        student.setName("Эйд");
        student.setGroupp(groupp);

        //save (persist) to DB
        entityManager.persist(groupp);
        entityManager.persist(student);

        transaction.commit();

        entityManager.close();
        emf.close();

    }
}
