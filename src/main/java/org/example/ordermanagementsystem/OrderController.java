package org.example.ordermanagementsystem;

public class OrderController {
    private final Inventory inventory;

    public OrderController(Inventory inventory){
        this.inventory = inventory;
    }

    public Order createOrder(User user, Delivery delivery){
        Cart cart = user.getCart();
        cart.getCartItems().forEach((itemId, cartItem) -> {
        if (!inventory.reduceStock(itemId, cartItem.getQuantity())) {
            throw new RuntimeException("Insufficient stock for item: "+ cartItem.getItem().getName());
        }
        });

        return new Order(generateOrderId(), cart);
    }

    private int generateOrderId(){
        return (int) (Math.random() * 1000);
    }

    public boolean processPayment(Order order, String paymentMethod){
        double amount = order.calculateTotalCost();
        return PaymentGateway.processpayment(amount, paymentMethod);
    }


}
