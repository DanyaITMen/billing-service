package com.automarket;
// клас, у який перетвориться JSON-повідомлення

// Це структура повідомлення, яке ми чекаємо від Orders
public class Invoice {
    public double price;
    public String car;
    public String user;

    public Invoice() {} // Порожній конструктор обов'язковий

    @Override
    public String toString() {
        return "RAXYNOK { KLIENT='" + user + "', AVTO='" + car + "', SUMA=" + price + " }";
    }
}