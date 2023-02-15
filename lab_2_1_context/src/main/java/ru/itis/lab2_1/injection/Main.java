package ru.itis.lab2_1.injection;

public class Main {

    public static void main(String[] args) {
        ClientRepository repository = new ClientRepository();

        System.out.println(repository.getClientByNameFromDB("Kamil").toString());

    }
}
