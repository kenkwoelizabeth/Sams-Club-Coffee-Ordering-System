package com.techbridge.sams.club.order;


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
public class OrderController {
    @Autowired
    private OrderService orderService;



    @GetMapping("/order")
    public String getAllOrder(Model model) {
        model.addAttribute("listOrders", orderService.getAllOrder());
        return "order/order_list";
    }


    @GetMapping("/my_orders")
    public String getMyOrders(Model model) {
        // create model attribute to bind form data
      Order order  = new Order();
        model.addAttribute("order", order);
        return "order/new_order";
    }

    @PostMapping("/saveOrder")
    public String saveOrder(@ModelAttribute("order") @Valid Order order ,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "order/new_order";
        }
        // save menu to database
        orderService.saveOrder(order);
        return "redirect:/order";
    }

    @GetMapping("/my_orders/{id}")
    public String getOrdersById(@PathVariable(value = "id") int orderId, Model model) {

        Order order  = orderService.getOrderById(orderId);
        model.addAttribute("order", order);

        return "order/update_order";
    }

    @GetMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable(value = "id") int orderId) {
        this.orderService.deleteOrder(orderId);

        return "redirect:/order";
    }

}
