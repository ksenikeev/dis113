package ru.itis.dis.lab2_3.components;

import ru.itis.dis.lab2_3.IWeatherService;
import ru.itis.dis.lab2_3.annotations.Component;
import ru.itis.dis.lab2_3.annotations.Inject;

import java.util.Collection;
import java.util.List;

@Component
public class Main implements Runnable {

    @Inject
    private IWeatherService service;

    List<String> lst;

    Collection<String> c;

    @Override
    public void run() {
        String response =
                service.getWeather("55","49");

        System.out.println(response);
    }
}
