package ru.itis.lab2_6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.lab2_6.config.ApplicationConfig;
import ru.itis.lab2_6.model.*;
import ru.itis.lab2_6.services.PersonService;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);


        PersonService service = context.getBean(PersonService.class);

        Car car1 = new Car();
        car1.setCarNumber("A111AA116RUS");
        car1.setCarModel(CarModel.GAZ);
        service.save(car1);

        Driver driver = new Driver();
        driver.setName("Driver 2");
        driver.setPhone("33333");
        driver.setCar(car1);

        service.save(driver);

        TaxiCompany yandexTaxi = new TaxiCompany();
        yandexTaxi.setName("Яндекс.Такси");

        List<Driver> drivers = new ArrayList<>();
        drivers.add(driver);

        yandexTaxi.setDrivers(drivers);

        service.save(yandexTaxi);
    }
}
