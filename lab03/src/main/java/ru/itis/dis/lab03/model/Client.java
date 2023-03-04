package ru.itis.dis.lab03.model;

public class Client {
    private String name;
    private String passport;

    public Client(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public Client() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
}
