package ru.itis.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import ru.itis.service.models.Course;
import ru.itis.service.repositories.CoursesRepository;
import ru.itis.service.repositories.DisciplinesRepository;
import ru.itis.service.repositories.UsersRepository;
import ru.itis.service.utils.TestDataUtil;
@SpringBootApplication
public class RestApiDemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(RestApiDemoApplication.class, args);
        TestDataUtil testDataUtil = context.getBean(TestDataUtil.class);
        testDataUtil.initializeData();
    }

}
