package com.techbridge.sams.club.order;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderRestController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public Order saveOrder(@RequestBody Order order) {

        return orderService.saveOrder(order);
    }

    @GetMapping("/my_orders")
    public List<Order> getOrders() {

        return orderService.getAllOrder();

    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable(value = "id") long orderId) {
        Order existingOrder = orderService.getOrderById(orderId);

        return ResponseEntity.ok(existingOrder);
    }

    @PutMapping("/order/{id}")
    public String updateOrder(@PathVariable("id") long orderId, @RequestBody Order order) {
        orderService.updateOrder(orderId, order);
        return "redirect:/myOrder";
    }

    @DeleteMapping("/orders/{id}")
    public String deleteStore(@PathVariable("id") long orderId) {
        orderService.deleteOrder(orderId);
        return "redirect:/orders";
    }

}


