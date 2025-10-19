package com.automarket;

import com.automarket.grpc.OrderStatusRequest;
import com.automarket.grpc.OrderStatusResponse;
import com.automarket.grpc.OrderServiceGrpc;
import io.quarkus.grpc.GrpcClient;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrderServiceGrpcClient {

    @GrpcClient("orders") // Назву залишаємо, як налаштували раніше
    OrderServiceGrpc.OrderServiceBlockingStub orderService;

    // Новий метод, що приймає ID
    public OrderStatusResponse getOrderStatus(int orderId) {
        OrderStatusRequest request = OrderStatusRequest.newBuilder()
                .setOrderId(orderId)
                .build();
        return orderService.getOrderStatus(request);
    }
}