package ru.itis.lab2_4_spring.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.lab2_4_spring.components.Amount;
import ru.itis.lab2_4_spring.components.FirstBank;

public class Main {
    public static void main(String[] args) {
        // Создание контекста
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        // Получение экземпляра бина
        Amount client1 = (Amount) context.getBean("amount");
        System.out.println("Current amount: " + client1.getAmount() + " in bank:" + client1.getBank());
        client1.setAmount(500d);

        Amount client2 = (Amount) context.getBean("amount");
        System.out.println(client2.equals(client1));
        System.out.println("Current amount: " + client2.getAmount() + " in bank:" + client1.getBank());

        FirstBank bank = (FirstBank) context.getBean("bank");
        System.out.println(bank);

    }
}
