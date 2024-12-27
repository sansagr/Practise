package org.example.onlinebookstore.models;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Order {
    private String orderId;
    private String userId;
    private List<OrderItem> orderItems;
    private LocalDateTime createdAt;
    private String status;
    private double totalPrice;

    public Order(String orderId, String userId, List<OrderItem> orderItems, LocalDateTime createdAt, String status, double totalPrice ){
        this.orderId = orderId;
        this.userId = userId;
        this.orderItems = orderItems;
        this.createdAt = createdAt;
        this.status = status;
        this.totalPrice = totalPrice;
    }
}
