package com.techbridge.sams.club.cartitem;


import com.techbridge.sams.club.menuitem.MenuItem;

import java.util.List;

public interface CartItemService {
    List<CartItem> getAllCartItems();
    void saveCartItem(CartItem cartItem);
    CartItem getCartItemById(long id);
    void deleteCartItemById(long id);
    CartItem getNewCartItemFromMenuItem(MenuItem menuItem);
}
