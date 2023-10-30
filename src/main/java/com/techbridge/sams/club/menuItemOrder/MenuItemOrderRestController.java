package com.techbridge.sams.club.menuItemOrder;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MenuItemOrderRestController {
    @Autowired
    private MenuItemOrderService menuItemOrderService;

    @GetMapping("/menuItemOrders")
    public MenuItemOrder saveMenuItemOrder(@RequestBody MenuItemOrder menuItemOrder) {

        return menuItemOrderService.saveMenuItemOrder(menuItemOrder);
    }

    @GetMapping("/my_menuItemOrders")
    public List<MenuItemOrder> getMenuItemOrders() {

        return menuItemOrderService.getAllMenuItemOrder();

    }

    @GetMapping("/menuItemOrder/{id}")
    public ResponseEntity<MenuItemOrder> getMenuItemOrderById(@PathVariable(value = "id") long orderId) {
        MenuItemOrder existingOrder = menuItemOrderService.getMenuItemOrderById(orderId);

        return ResponseEntity.ok(existingOrder);
    }

    @PutMapping("/menuItemOrder/{id}")
    public String updateOrder(@PathVariable("id") long orderId, @RequestBody MenuItemOrder menuItemOrder) {
        menuItemOrderService.updateMenuItemOrder(orderId, menuItemOrder);
        return "redirect:/myMenuItemOrder";
    }

    @DeleteMapping("/menuItemOrders/{id}")
    public String deleteMenuItemOrder(@PathVariable("id") long orderId) {
        menuItemOrderService.deleteMenuItemOrder(orderId);
        return "redirect:/menuItemOrders";
    }

}


