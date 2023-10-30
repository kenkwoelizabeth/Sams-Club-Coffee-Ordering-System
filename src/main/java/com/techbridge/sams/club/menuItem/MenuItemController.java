package com.techbridge.sams.club.menuItem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/menu")
    public String getAllMenu(Model model) {
        model.addAttribute("listMenus", menuItemService.getAllMenu());
        return "menu/menu_list";
    }


    @GetMapping("/my_menus")
    public String getMyMenus(Model model) {
        // create model attribute to bind form data
        MenuItem menu = new MenuItem();
        model.addAttribute("menu", menu);
        return "menu/new_menu";
    }

    @PostMapping("/saveMenu")
    public String saveMenu(@ModelAttribute("menu") @Valid MenuItem menuItem,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "menu/new_menu";
        }
        // save menu to database
        menuItemService.saveMenu(menuItem);
        return "redirect:/menu";
    }

    @GetMapping("/my_menus/{id}")
    public String getMenusById(@PathVariable(value = "id") int menuId, Model model) {

        MenuItem menu = menuItemService.getMenuById(menuId);
        model.addAttribute("menu", menu);

        return "menu/update_menu";
    }

    @GetMapping("/deleteMenu/{id}")
    public String deleteMenu(@PathVariable(value = "id") int menuId) {
        this.menuItemService.deleteMenu(menuId);

        return "redirect:/menu";
    }

    @GetMapping("/menu-items")
    public String searchMenuItems(@RequestParam(name = "name", required = false) String name, Model model) {
        List<MenuItem> menuItems = menuItemService.searchMenuItems(name);
        model.addAttribute("listMenus", menuItems);
        model.addAttribute("name", name);
        return "menu/menu_list";
    }

}
