package ru.itis.dis.lab2_2.components;

import ru.itis.dis.lab2_2.annotations.Component;
import ru.itis.dis.lab2_2.annotations.Inject;

@Component
public class Main implements Runnable {

    @Inject
    private TestComponent testComponent;

    @Override
    public void run() {
        System.out.println(testComponent.getComponentInfo());
    }
}
