package ru.itis.lab2_5_JPA.hibernate.inherit;

import ru.itis.lab2_5_JPA.hibernate.model.taxi.Client;
import ru.itis.lab2_5_JPA.hibernate.model.taxi.Driver;
import ru.itis.lab2_5_JPA.hibernate.model.univer.Student;

import javax.persistence.*;

public class MainInheritance {
    public static void main(String[] args) {
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("lab2_5");

        EntityManager entityManager = emf.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Client client = new Client();
        client.setName("client1");
        client.setPhone("11111111");

        Driver driver = new Driver();
        driver.setName("driver1");
        driver.setPhone("222222");

        entityManager.persist(client);
        entityManager.persist(driver);

        transaction.commit();

        entityManager.close();
        emf.close();

    }
}
