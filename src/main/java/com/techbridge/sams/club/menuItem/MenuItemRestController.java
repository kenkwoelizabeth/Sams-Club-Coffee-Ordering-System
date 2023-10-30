package com.techbridge.sams.club.menuItem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MenuItemRestController {
    @Autowired
    private MenuItemService menuItemService;


    @PostMapping("/menus")
    public MenuItem saveMenu(@RequestBody MenuItem menuItem) {

        return menuItemService.saveMenu(menuItem);
    }

    @GetMapping("/my_menus")
    public List<MenuItem> getMenus() {

        return menuItemService.getAllMenu();

    }

    @GetMapping("/menu/{id}")
    public ResponseEntity<MenuItem> getMenuById(@PathVariable(value = "id") long menuId) {
        MenuItem existingMenu = menuItemService.getMenuById(menuId);

        return ResponseEntity.ok(existingMenu);
    }

    @PutMapping("/menu/{id}")
    public String updateMenu(@PathVariable("id") long menuId, @RequestBody MenuItem menuItem) {
        menuItemService.updateMenu(menuId, menuItem);
        return "redirect:/myMenu";
    }

    @DeleteMapping("/menus/{id}")
    public String deleteMenu(@PathVariable("id") long menuId) {
        menuItemService.deleteMenu(menuId);
        return "redirect:/menus";
    }

}