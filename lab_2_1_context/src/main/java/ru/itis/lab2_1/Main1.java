package ru.itis.lab2_1;

public class Main1 {
    public static void main(String[] args) {
        ClientRepository1 repository = new ClientRepository1();

        System.out.println(repository.getClientByNameFromDB("Kamil"));

    }
}
