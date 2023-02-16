package ru.itis.dis.lab2_3.components;

import ru.itis.dis.lab2_3.annotations.Component;
import ru.itis.dis.lab2_3.annotations.Inject;

@Component
public class Main implements Runnable {

    @Inject
    private WeatherService service;

    @Override
    public void run() {
        String response =
                service.getWeather("55","49");

        System.out.println(response);
    }
}
