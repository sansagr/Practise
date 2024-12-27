package org.example.ordermanagementsystem;

public class User {
    private final String name;
    private final String email;
    private final int age;
    private Cart cart;

    public User(String name, String email, int age){
        this.name = name;
        this.email = email;
        this.age = age;
        this.cart = new Cart();
    }

    public Cart getCart() {
        return cart;
    }

    public String getName() {
        return name;
    }

    public void setCart(Cart cart){
        this.cart = cart;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}
