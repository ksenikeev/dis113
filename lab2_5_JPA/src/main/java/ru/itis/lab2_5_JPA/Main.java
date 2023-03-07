package ru.itis.lab2_5_JPA;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.lab2_5_JPA.component.PersonService;
import ru.itis.lab2_5_JPA.config.ApplicationConfig;
import ru.itis.lab2_5_JPA.model.Person;

import java.text.ParseException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);

        PersonService service = context.getBean(PersonService.class);

        try {
            List<Person> lst = service.getAll();

            lst.forEach(person -> System.out.println(person));

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
