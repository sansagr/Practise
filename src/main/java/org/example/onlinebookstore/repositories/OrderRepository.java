package org.example.onlinebookstore.repositories;

import org.example.onlinebookstore.models.CartItem;
import org.example.onlinebookstore.models.Order;

import java.util.*;

public class OrderRepository {
    public Map<String, Order> orderDatabase;

    public OrderRepository(){
        this.orderDatabase = new HashMap<>();
    }

    public void createOrder(Order order){
        orderDatabase.put(order.getOrderId(), order);
    }

    public Optional<Order> findById(String orderId){
        return Optional.ofNullable(orderDatabase.get(orderId));
    }

    public List<Order> findByUserId(String userId){
        List<Order> orders = new ArrayList<>();

        for(Order order: orderDatabase.values()){
            if (order.getUserId().equals(userId)){
                orders.add(order);
            }
        }
        return orders;
    }

    public void deleteOrder(String orderId){
        orderDatabase.remove(orderId);
    }
}
