package com.techbridge.sams.club.order;


import com.techbridge.sams.club.cart.Cart;

import java.util.Date;
import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    void saveOrder(Order order);
    Order getOrderById(long id);
    void deleteOrderById(long id);

    void copyInfoFromCart(Order order, Cart cart);

    List<Order> findByCustomerFirstNameContainingOrCustomerLastNameContaining(String firstNameInfix, String lastNameInfix);
    List<Order> findByDeliveryDateEquals(Date deliveryDate);
    List<Order> findByLocationContaining(String locationInfix);
}
