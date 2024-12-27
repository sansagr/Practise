package org.example.ordermanagementsystem;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Cart {
    private Map<Integer, CartItem> cartItems;

    public Cart(){
        this.cartItems = new HashMap<>();
    }

    public Map<Integer, CartItem> getCartItems(){
        return Map.copyOf(this.cartItems);
    }

    public void addToCart(Item item, int quantity){
        cartItems.put(item.getId(), new CartItem(item, quantity));
    }

    public void removeFromCart(Item item, int quantity){
        if (cartItems.containsKey(item.getId())){
            if (cartItems.get(item.getId()).getQuantity() <= quantity) {
                cartItems.remove(item.getId());
            } else {
                cartItems.computeIfPresent(item.getId(), (k, existingItem) -> {
                    existingItem.setQuantity(existingItem.getQuantity() - quantity);
                    return existingItem;
                });
            }
        }
    }

    public double calculateCost(){
        double cost = 0.0;
        for (Integer key: cartItems.keySet()){
            CartItem item = cartItems.get(key);
            cost += item.getQuantity()*item.getItem().getCost();
        }

        return cost;
    }
}
