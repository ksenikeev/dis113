package ru.itis.dis.lab03.service;

import ru.itis.dis.lab03.model.Bank;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLBankService {

    public void convertClassToXML(Bank bank, String fileName) {
        try {
            JAXBContext context = JAXBContext.newInstance(Bank.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // маршаллинг объекта в файл
            marshaller.marshal(bank, new File(fileName));
        } catch (
                JAXBException e) {
            e.printStackTrace();
        }
    }

    public Bank convertXMLToClass(String fileName) {
        Bank bank2 = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Bank.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            bank2 = (Bank) un.unmarshal(new File(fileName));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return bank2;
    }

}
