package org.example.onlinebookstore.controllers;

import org.example.onlinebookstore.services.CartService;

public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService){
        this.cartService = cartService;
    }

//    define routes that takes in parameters send the request to relevant function and get a response
    public void addOrUpdateItemInCart(String userId, String itemId, int quantity){
        cartService.addOrUpdateItemInCart(userId, itemId, quantity);
    }

    public void removeItemFromCart(String userId,String itemId){
        cartService.removeFromCart(userId, itemId);
    }

    public void getCart(String userId){
        cartService.getCart(userId);
    }
}
