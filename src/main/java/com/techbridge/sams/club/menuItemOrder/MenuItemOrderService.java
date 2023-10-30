package com.techbridge.sams.club.menuItemOrder;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuItemOrderService {

    public MenuItemOrder saveMenuItemOrder(MenuItemOrder menuItemOrder);

    public List<MenuItemOrder> getAllMenuItemOrder();


    public MenuItemOrder getMenuItemOrderById(long orderId);

    public MenuItemOrder updateMenuItemOrder(long orderId, MenuItemOrder menuItemOrder);

    public void deleteMenuItemOrder(long orderId);
}


