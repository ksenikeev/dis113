package ru.itis.lab2_4_spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.itis.lab2_4_spring.components.Amount;
import ru.itis.lab2_4_spring.components.Bank;
import ru.itis.lab2_4_spring.components.ClientAmount;
import ru.itis.lab2_4_spring.components.FirstBank;

// Описываем контекст через класс-конфигурацию
@Configuration
public class Config {

    @Bean
    public Bank bank() {
        FirstBank bank = new FirstBank("Банк N 1");
        bank.setBranchOffice("Офис 2");
        return bank;
    }

    @Bean
    @Scope("prototype")
    public Amount amount() {
        ClientAmount amount = new ClientAmount(5000d);
        amount.setBank(bank());
        return amount;
    }

}
