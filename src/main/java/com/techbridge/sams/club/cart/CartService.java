package com.techbridge.sams.club.cart;

import java.util.List;

public interface CartService {
    List<Cart> getAllCarts();
    void saveCart(Cart cart);
    Cart getCartById(long id);
    void deleteCartById(long id);
    void addMenuItemToCartById(Cart cart, long menuItemId);
}
