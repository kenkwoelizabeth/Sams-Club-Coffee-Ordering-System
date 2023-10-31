package com.techbridge.sams.club.menuItemOrder;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class MenuItemOrderController {
    @Autowired
    private MenuItemOrderService menuItemOrderService;



    @GetMapping("/menuItemOrder")
    public String getAllMenuItemOrder(Model model) {
        model.addAttribute("listMenuItemOrders", menuItemOrderService.getAllMenuItemOrder());
        return "menuItemOrder/menuItemOrder_list";
    }


    @GetMapping("/my_menuItemOrders")
    public String getMyMenuItemOrders(Model model) {
        // create model attribute to bind form data
      MenuItemOrder menuItemOrder  = new MenuItemOrder();
        model.addAttribute("menuItemOrder", menuItemOrder);
        return "menuItemOrder/new_menuItemOrder";
    }

    @PostMapping("/saveMenuItemOrder")
    public String saveMenuItemOrder(@ModelAttribute("menuItemOrder") @Valid MenuItemOrder menuItemOrder ,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "menuItemOrder/new_menuItemOrder";
        }
        // save menu to database
        menuItemOrderService.saveMenuItemOrder(menuItemOrder);
        return "redirect:/menuItemOrder";
    }

    @GetMapping("/my_menuItemOrders/{id}")
    public String getMenuItemOrdersById(@PathVariable(value = "id") long orderId, Model model) {

        MenuItemOrder menuItemOrder = menuItemOrderService.getMenuItemOrderById(orderId);
        model.addAttribute("menuItemOrder", menuItemOrder);

        return "menuItemOrder/update_menuItemOrder";
    }

    @GetMapping("/deleteMenuItemOrder/{id}")
    public String deleteMenuItemOrder(@PathVariable(value = "id") long orderId) {
        this.menuItemOrderService.deleteMenuItemOrder(orderId);

        return "redirect:/menuItemOrder";
    }


}
