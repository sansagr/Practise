package org.example.ordermanagementsystem;

public class Order {
    private int id;
    private Cart cart;

    public Order(int id, Cart cart){
        this.id = id;
        this.cart = cart;
    }

    public int getId(){
        return this.id;
    }

    public Cart getCart(){
        return this.cart;
    }

    public double calculateTotalCost(){
        return cart.calculateCost();
    }


}
