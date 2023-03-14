package ru.itis.lab2_5_JPA.annotations.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.itis.lab2_5_JPA.annotations.model.Person;

import java.text.ParseException;
import java.util.List;

// @Component - этот класс будет создаваться как бин
@Component
@Scope("singleton") // prototype
public class PersonService {

    // @Autowired - DI (инъекция зависимости Spring контейнером)
    @Autowired
    PersonRepository repository;

    public List<Person> getAll() throws ParseException {
        return repository.getAll();
    }

}
