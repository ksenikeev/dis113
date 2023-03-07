package ru.itis.lab2_5_JPA.component;

import org.springframework.stereotype.Component;
import ru.itis.lab2_5_JPA.model.Person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

// @Component - этот класс будет создаваться как бин
@Component
public class PersonRepository {

    public List<Person> getAll() throws ParseException {
        List<Person> result = new ArrayList<>();

        result.add(new Person(1L, "Kamil", new SimpleDateFormat("dd.MM.yyyy").parse("01.01.1975")));
        result.add(new Person(2L, "Ahmad", new SimpleDateFormat("dd.MM.yyyy").parse("01.01.2001")));

        return result;
    }

}
