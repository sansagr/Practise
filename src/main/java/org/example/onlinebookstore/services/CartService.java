package org.example.onlinebookstore.services;

import org.example.onlinebookstore.models.Book;
import org.example.onlinebookstore.models.Cart;
import org.example.onlinebookstore.models.CartItem;
import org.example.onlinebookstore.repositories.BookInventoryRepository;
import org.example.onlinebookstore.repositories.BookRepository;
import org.example.onlinebookstore.repositories.CartRepository;

public class CartService {
    private final CartRepository cartRepository;
    private final BookInventoryRepository bookInventoryRepository;
    private final BookRepository bookRepository;
    private final BookInventoryRepository inventoryRepository;

    public CartService(CartRepository cartRepository, BookInventoryRepository bookInventoryRepository, BookRepository bookRepository, BookInventoryRepository inventoryRepository) {
        this.bookInventoryRepository = bookInventoryRepository;
        this.cartRepository = cartRepository;
        this.bookRepository = bookRepository;
        this.inventoryRepository = inventoryRepository;
    }

    //    also add method to update the quantity of item in inventory
    public void addOrUpdateItemInCart(String userId, String itemId, int quantity) {
        Book book = bookRepository.getBook(itemId);
        if (bookInventoryRepository.getBookQuantity(itemId) >= quantity) {
            Cart cart = cartRepository.getCartByUserId(userId);
            if (cart.getItems().containsKey(itemId)) {
                int existingQuantity = cart.getItems().get(itemId).getQuantity();
                if ((existingQuantity + quantity) <= 0) {
                    cart.getItems().remove(itemId);
                } else {
                    cart.getItems().get(itemId).setQuantity(existingQuantity + quantity);
                }
            }
            else{
                cart.getItems().put(itemId, new CartItem(itemId, quantity, book));
            }
            recalculateCartTotal(cart);
            cartRepository.saveCart(cart);
        } else {
            throw new IllegalArgumentException("Insufficient inventory for itemid:" + itemId);
        }
    }

    public Cart getCart(String userId){
        return cartRepository.getCartByUserId(userId);
    }

    public double getCartTotal(String userId) {
        Cart cart = cartRepository.getCartByUserId(userId);
        double totalPrice = 0.0;
        if (!cart.getItems().isEmpty()) {
            for(CartItem item : cart.getItems().values()){
                totalPrice += item.getBook().getPrice()* item.getQuantity();
            }
        }
        return totalPrice;
    }

    private void recalculateCartTotal(Cart cart){
        double totalPrice = 0.0;
        if (!cart.getItems().isEmpty()) {
            for(CartItem item : cart.getItems().values()){
                totalPrice += item.getBook().getPrice()* item.getQuantity();
            }
        }
        cart.setTotalPrice(totalPrice);
    }

    public void removeFromCart(String userId, String itemId) {
        Cart cart = cartRepository.getCartByUserId(userId);
        if (cart == null){
            throw new IllegalArgumentException("Cart not found for user" + userId);
        }
        if (cart.getItems().containsKey(itemId)){
            cart.getItems().remove(itemId);
            recalculateCartTotal(cart);
            cartRepository.saveCart(cart);
        }
        else{
            throw new IllegalArgumentException("Item not found for userId" + userId);
        }
    }

    public void clearCart(String userId) {
        cartRepository.clearCart(userId);
    }
}
