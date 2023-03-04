package ru.itis.lab2_1;

import java.util.ArrayList;
import java.util.List;

public class Main3 {
    public static void main(String[] args) {

        List<Client> clientList = new ArrayList<>();
        Client client1 = new Client();
        client1.setName("Kamil");
        Client client2 = new Client();
        client2.setName("Nasib");
        clientList.add(client1);
        clientList.add(client2);


        ClientRepository3 repository = new ClientRepository3(clientList);

        System.out.println(repository.getClientByNameFromDB("Kamil"));

    }
}
