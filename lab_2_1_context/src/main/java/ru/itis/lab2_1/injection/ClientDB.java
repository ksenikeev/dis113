package ru.itis.lab2_1.injection;

import ru.itis.lab2_1.Client;

import java.util.List;

@Component
public class ClientDB {
    private List<Client> clients;



    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
