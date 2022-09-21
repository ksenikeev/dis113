package ru.itis.dis.lab03;

import ru.itis.dis.lab03.model.Bank;
import ru.itis.dis.lab03.model.Client;
import ru.itis.dis.lab03.service.XMLBankService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Client client1 = new Client("Клиент 1", "111 11111");
        Client client2 = new Client("Клиент 2", "222 22222");

        List<Client> clients = new ArrayList<>();
        clients.add(client1);
        clients.add(client2);

        Bank bank = new Bank();
        bank.setName("Банк 1");
        bank.setClients(clients);

        XMLBankService service = new XMLBankService();

        service.convertClassToXML(bank, "bank.xml");

        Bank bank1 = service.convertXMLToClass("bank1.xml");

        System.out.println(bank1.getName());
        bank1.getClients().forEach(client -> System.out.println(client.getName()));

    }
}
