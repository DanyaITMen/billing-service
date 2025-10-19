package com.automarket;

import com.automarket.grpc.OrderStatusResponse;
import io.quarkus.logging.Log;
import io.vertx.core.json.JsonObject;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.reactive.messaging.Incoming; // Для RabbitMQ

@Path("/billing")
public class BillingService {

    @Inject
    OrderServiceGrpcClient orderClient;

    // === СТАРИЙ КОД (HTTP/gRPC) ===
    @GET
    @Path("/{orderId}")
    @Produces(MediaType.APPLICATION_JSON)
    public BillingStatusDTO getBillingStatus(@PathParam("orderId") int orderId) {
        OrderStatusResponse grpcResponse = orderClient.getOrderStatus(orderId);
        return new BillingStatusDTO(
                grpcResponse.getOrderId(),
                grpcResponse.getProductName(),
                grpcResponse.getStatus()
        );
    }

    // === НОВИЙ КОД (RabbitMQ) ===
    // Цей метод слухає канал "invoices-rabbitmq"
    @Incoming("invoices-rabbitmq")
    public void processInvoice(JsonObject json) {
        // Перетворюємо JSON в наш об'єкт
        Invoice invoice = json.mapTo(Invoice.class);

        // Просто виводимо в консоль (імітуємо обробку)
        Log.info("💰 [Billing Service] Отримано новий рахунок на оплату!");
        Log.info(invoice.toString());
        System.out.println("------------------------------------------------");
    }
}