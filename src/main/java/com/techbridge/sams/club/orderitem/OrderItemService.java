package com.techbridge.sams.club.orderitem;

import java.util.List;

public interface OrderItemService {
    List<OrderItem> getAllOrderItems();
    void saveOrderItem(OrderItem orderItem);
    OrderItem getOrderItemById(long id);
    void deleteOrderItemById(long id);
}
