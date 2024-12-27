package org.example.onlinebookstore.services;

import org.example.onlinebookstore.models.Cart;
import org.example.onlinebookstore.models.CartItem;
import org.example.onlinebookstore.models.Order;
import org.example.onlinebookstore.models.OrderItem;
import org.example.onlinebookstore.repositories.CartRepository;
import org.example.onlinebookstore.repositories.OrderRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OrderManagementService {
    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;

    public OrderManagementService(CartRepository cartRepository, OrderRepository orderRepository) {
        this.cartRepository = cartRepository;
        this.orderRepository = orderRepository;
    }

    public String createOrder(String userId) {
        Cart userCart = cartRepository.getCartByUserId(userId);
        if (userCart == null || userCart.getItems().isEmpty()) {
            throw new IllegalArgumentException("Cart is empty for user:" + userId);
        }

        List<OrderItem> orderItems = new ArrayList<>();
        double totalPrice = 0;
        for (CartItem cartItem : userCart.getItems().values()) {
            OrderItem order = new OrderItem(
                    cartItem.getBookId(),
                    cartItem.getBook().getName(),
                    cartItem.getQuantity(),
                    cartItem.getBook().getPrice());
            orderItems.add(order);
            totalPrice += cartItem.getBook().getPrice() * cartItem.getQuantity();
        }

        Order order = new Order(
                UUID.randomUUID().toString(),
                userId,
                orderItems,
                LocalDateTime.now(),
                "CREATED",
                totalPrice
        );

        orderRepository.createOrder(order);
        cartRepository.clearCart(userId);

        return order.getOrderId();
    }

    public List<Order> getOrderByUserId(String userId){
        return orderRepository.findByUserId(userId);
    }

    public Optional<Order> getOrderByOrderId(String orderId){
        return orderRepository.findById(orderId);
    }
}
