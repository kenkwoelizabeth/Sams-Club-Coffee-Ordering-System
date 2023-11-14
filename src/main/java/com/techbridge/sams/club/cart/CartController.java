package com.techbridge.sams.club.cart;


import com.techbridge.sams.club.menuitem.MenuItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartController {
    private CartService cartService;
    private MenuItemService menuItemService;

    @Autowired
    public CartController(CartService cartService, MenuItemService menuItemService
    ) {
        this.cartService = cartService;
        this.menuItemService = menuItemService;
    }

    @PostMapping("/addToCart/{menu_item_id}")
    public String addToCart(
            @PathVariable(value = "menu_item_id") long menuItemId,
            @ModelAttribute("cart") Cart cart,
            BindingResult bindingResult,
            Model model) {

        cartService.addMenuItemToCartById(cart, menuItemId);
        cartService.saveCart(cart);

        Logger logger = LoggerFactory.getLogger(CartController.class);
        logger.info("Menu item with id " + menuItemId + " has been added to cart");

        model.addAttribute("listMenuItems", menuItemService.getAllMenuItems());
        model.addAttribute("cart", cart); // already in the model, but need to update the id?

        return "order";
    }


}
