package ru.itis.lab2_6.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.itis.lab2_6.model.AbstractEntity;
import ru.itis.lab2_6.model.Person;

@Service
public class PersonService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public <T extends AbstractEntity> T save(T person) {
        if (person == null) return null;
        if (person.getId() == null) {
            entityManager.persist(person);
        } else {
            person = entityManager.merge(person);
        }
        return person;
    }

}
