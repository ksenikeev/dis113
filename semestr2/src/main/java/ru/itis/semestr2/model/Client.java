package ru.itis.semestr2.model;

public class Client extends User{

    public Client() {}

    public Client(String phone) {
        this.setPhone(phone);
    }
    public Client(Integer id, String phone) {
        this.setId(id);
        this.setPhone(phone);
    }
}
