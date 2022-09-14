package ru.itis.db.lab2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JsonProcessingException, JAXBException {
        DataBase dataBase = new DataBase();

        Client client1 = new Client("Kamil","ksenikeev@mail.ru");

        Market market = new Market("ЦУМ", "www.cum.ru","Универсам");

        Store store = new Store(market, "Казань");

        Merch merch1 = new Merch("001","Котик", 1000f, store, 2);
        Merch merch2 = new Merch("002","Пирожок", 10f, store, 50);
        List<Merch> merches = new ArrayList<>();
        merches.add(merch1);
        merches.add(merch2);

        Basket basket1 = new Basket(client1, "09.09.2022",
                "10.09.2022",merches,1010f);

        List<Basket> baskets = new ArrayList<>();
        baskets.add(basket1);

        dataBase.setBaskets(baskets);

        ObjectMapper mapper = new ObjectMapper();
        String str = mapper.writeValueAsString(dataBase);

        System.out.println(str);

        JAXBContext context = JAXBContext.newInstance(DataBase.class);
        Marshaller mar= context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(dataBase, new File("db.xml"));
    }
}
