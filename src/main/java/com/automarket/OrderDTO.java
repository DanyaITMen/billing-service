package com.automarket;

// Простий Java-клас (POJO/DTO) для представлення замовлення у форматі JSON
public class OrderDTO {
    public int id;
    public String productName;
    public int quantity;

    // Конструктор для зручного перетворення
    public OrderDTO(int id, String productName, int quantity) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
    }
}