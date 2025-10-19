package com.automarket;
// Клас для зберігання інформації про рахунок (id, замовлення, сума).
public class Bill {
    private int id;
    private int orderId;
    private double amount;

    public Bill() {
    }

    public Bill(int id, int orderId, double amount) {
        this.id = id;
        this.orderId = orderId;
        this.amount = amount;
    }

    // Геттеры и сеттеры
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}
