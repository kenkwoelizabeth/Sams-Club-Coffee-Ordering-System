package com.techbridge.sams.club.menuItemOrder;


import com.techbridge.sams.club.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.awt.*;
import java.util.Date;
import java.util.List;

@Service
public class MenuItemOrderServiceImpl implements MenuItemOrderService {

    @Autowired
    private MenuItemOrderRepository menuItemOrderRepository;


    @Override
    public MenuItemOrder saveMenuItemOrder(MenuItemOrder menuItemOrder) {
        return menuItemOrderRepository.save(menuItemOrder);
    }

    @Override
    public List<MenuItemOrder> getAllMenuItemOrder() {
        return menuItemOrderRepository.findAll();
    }

    @Override
    public MenuItemOrder getMenuItemOrderById(long orderId) {
        return menuItemOrderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order does not exist with the ID: " + orderId));
    }

    @Override
    public MenuItemOrder updateMenuItemOrder(long orderId, MenuItemOrder menuItemOrder) {
        MenuItemOrder existingOrder = menuItemOrderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order does not exist with the ID: " + orderId));
        existingOrder.setPrice(menuItemOrder.getPrice());
        existingOrder.setMenuItem(menuItemOrder.getMenuItem());
        existingOrder.setQuantityOrdered(menuItemOrder.getQuantityOrdered());
        existingOrder.setOrderDate(menuItemOrder.getOrderDate());
        existingOrder.setCompleted(menuItemOrder.isCompleted());


        return menuItemOrderRepository.save(existingOrder);
    }

    @Override
    public void deleteMenuItemOrder(long orderId) {
        MenuItemOrder existingOrder = menuItemOrderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Menu Item Order does not exist with the ID: " + orderId));
        menuItemOrderRepository.delete(existingOrder);
    }
}
