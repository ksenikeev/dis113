package ru.itis.lab2_1;

import java.util.List;
import java.util.Optional;

public class ClientRepository3 {

    private List<Client> clients;

    public ClientRepository3(List<Client> clients) {
        this.clients = clients;
    }

    public Client getClientByNameFromDB(String name) {
        if (clients == null) return null;
        Optional<Client> result =
                clients.stream().filter(client -> name.equals(client.getName())).findFirst();
        return result.isPresent() ? result.get() : null;
    }
}
