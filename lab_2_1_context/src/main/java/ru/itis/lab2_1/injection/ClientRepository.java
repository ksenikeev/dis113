package ru.itis.lab2_1.injection;

import ru.itis.lab2_1.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ClientRepository {

    @Inject
    private ClientDB clientDB;

    public Client getClientByNameFromDB(String name) {
        if (clientDB.getClients() == null) return null;
        Optional<Client> result =
                clientDB.getClients().stream().filter(client -> name.equals(client.getName())).findFirst();
        return result.isPresent() ? result.get() : null;
    }
}
