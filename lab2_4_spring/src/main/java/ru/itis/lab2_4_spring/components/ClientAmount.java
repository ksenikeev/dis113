package ru.itis.lab2_4_spring.components;

public class ClientAmount implements Amount {
    // Храним состояние счета
    private Double amount;

    private Bank bank;

    // Инициализация счета
    public ClientAmount(Double amount) {
        this.amount = amount;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public Bank getBank() {
        return bank;
    }

    // изменение состояния счета
    @Override
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    // получить состояние счета
    @Override
    public double getAmount() {
        return amount;
    }
}
