package com.automarket;
// Клас-DTO для передачі даних про оплату: id, авто, статус платежу.
public class BillingStatusDTO {
    public int orderId;
    public String carName;
    public String paymentStatus;

    public BillingStatusDTO(int orderId, String carName, String paymentStatus) {
        this.orderId = orderId;
        this.carName = carName;
        this.paymentStatus = paymentStatus;
    }
}