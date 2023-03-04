package ru.itis.lab2_1;

public class Client {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                '}';
    }



}
