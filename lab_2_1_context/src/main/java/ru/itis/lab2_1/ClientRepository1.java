package ru.itis.lab2_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientRepository1 {

    private List<Client> clients;

    public ClientRepository1() {
        clients = new ArrayList<>();
        Client client1 = new Client();
        client1.setName("Kamil");
        Client client2 = new Client();
        client2.setName("Nasib");
        clients.add(client1);
        clients.add(client2);
    }

    public Client getClientByNameFromDB(String name) {
        if (clients == null) return null;
        Optional<Client> result =
                clients.stream().filter(client -> name.equals(client.getName())).findFirst();
        return result.isPresent() ? result.get() : null;
    }
}
