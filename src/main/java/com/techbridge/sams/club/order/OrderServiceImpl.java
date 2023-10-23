package com.techbridge.sams.club.order;


import com.techbridge.sams.club.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order does not exist with the ID: " + orderId));
    }

    @Override
    public Order updateOrder(long orderId, Order order) {
        Order existingOrder=orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException ("Order does not exist with the ID: " + orderId));
       existingOrder.setCustomerFirstName(order.getCustomerFirstName());
        existingOrder.getCustomerLastName(order.getCustomerLastName());
        existingOrder.getDeliveryAddress(order.getDeliveryAddress());
        existingOrder.getCustomerPhone(order.getCustomerPhone());
        existingOrder.getDeliveryOption(order.getDeliveryOption());
        existingOrder.setLocation(order.getLocation());
        existingOrder.setDeliveryDate(order.getDeliveryDate());
        existingOrder.setReadyTime(order.getReadyTime());
        existingOrder.setSubTotal(order.getSubTotal());
        existingOrder.setTax(order.getTax());
        existingOrder.setTotal(order.getTotal());





        return orderRepository.save(existingOrder);
    }

    @Override
    public void deleteOrder(long orderId) {
        Order existingOrder=orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException ("Order does not exist with the ID: " + orderId));
    orderRepository.delete(existingOrder);
    }
}
