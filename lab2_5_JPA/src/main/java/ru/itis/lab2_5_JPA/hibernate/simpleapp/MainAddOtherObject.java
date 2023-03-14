package ru.itis.lab2_5_JPA.hibernate.simpleapp;

import ru.itis.lab2_5_JPA.hibernate.model.univer.Groupp;
import ru.itis.lab2_5_JPA.hibernate.model.univer.Student;

import javax.persistence.*;

public class MainAddOtherObject {
    public static void main(String[] args) {
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("lab2_5");

        EntityManager entityManager = emf.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();


        transaction.commit();

        entityManager.close();

        entityManager = emf.createEntityManager();
        transaction = entityManager.getTransaction();
        transaction.begin();

        Query query = entityManager.createQuery("select g from Groupp g where id = :id ");
        query.setParameter("id", 1l);

        Groupp groupp = (Groupp) query.getSingleResult();

        Student student2 = new Student();
        //student2.setId(2L);
        student2.setName("Зиад");
        student2.setGroupp(groupp);

        //save (persist) to DB
        entityManager.persist(student2);

        transaction.commit();

        entityManager.close();
        emf.close();

    }
}
