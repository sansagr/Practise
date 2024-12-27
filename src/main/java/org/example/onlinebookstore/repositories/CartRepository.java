package org.example.onlinebookstore.repositories;

import org.example.onlinebookstore.models.Cart;

import java.util.HashMap;
import java.util.Map;

public class CartRepository {
    private final Map<String, Cart> cartDataBase;

    public CartRepository() {
        this.cartDataBase = new HashMap<>();
    }

    public Cart getCartByUserId(String userId) {
        return cartDataBase.getOrDefault(userId, new Cart(userId));
    }

    public void saveCart(Cart cart){
        cartDataBase.put(cart.getUserId(), cart);
    }

    public void updateCart(Cart cart){
        if(!cartDataBase.containsKey(cart.getUserId())){
            throw new IllegalArgumentException("Cart not found for user"+ cart.getUserId());
        }
        cartDataBase.put(cart.getUserId(), cart);
    }

    public void deleteCart(String userId){
        cartDataBase.remove(userId);
    }

    public void clearCart(String userId){
        Cart cart = cartDataBase.get(userId);
        cart.getItems().clear();
        cart.setTotalPrice(0.0);
    }

    public void removeItemFromCart(String userId, String itemId) {
        cartDataBase.get(userId).getItems().remove(itemId);
    }

}
