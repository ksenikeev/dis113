package ru.itis.dis.lab2_2.components;

import ru.itis.dis.lab2_2.annotations.Component;
import ru.itis.dis.lab2_2.annotations.Inject;

@Component
public class TestClass {

    @Inject
    public TestComponent testComponent;

    public void print() {
        System.out.println(testComponent.getComponentInfo());
    }

}
/*

    TestClass  ---> testComponent ---> TestComponent


 */