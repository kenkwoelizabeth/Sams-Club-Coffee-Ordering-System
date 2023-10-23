package com.techbridge.sams.club.order;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    public Order saveOrder(Order order);

    public List<Order> getAllOrder();


    public Order getOrderById(long orderId);
    public Order  updateOrder(long orderId, Order order);

    public void deleteOrder(long orderId) ;
}


