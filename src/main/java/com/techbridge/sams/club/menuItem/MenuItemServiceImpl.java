package com.techbridge.sams.club.menuItem;


import com.techbridge.sams.club.exception.ResourceNotFoundException;
import com.techbridge.sams.club.menuItemOrder.MenuItemOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.OneToMany;
import java.util.List;

@Service
public class MenuItemServiceImpl implements MenuItemService {
    @Autowired
    private MenuItemRepository menuItemRepository;

    @Override
    public MenuItem saveMenu(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    @Override
    public List<MenuItem> getAllMenu() {
        return menuItemRepository.findAll();
    }

    @Override
    public MenuItem getMenuById(long menuId) {
        return menuItemRepository.findById(menuId)
                .orElseThrow(() -> new ResourceNotFoundException("Menu does not exist with the ID: " + menuId));
    }

    @Override
    public MenuItem updateMenu(long menuId, MenuItem menuItem) {

        MenuItem existingMenu = menuItemRepository.findById(menuId)
                .orElseThrow(() -> new ResourceNotFoundException("Menu does not exist with the ID: " + menuId));

        existingMenu.setName(menuItem.getName());
        existingMenu.setDescription(menuItem.getDescription());
        existingMenu.setQuantityAvailable(menuItem.getQuantityAvailable());
        existingMenu.setPrice(menuItem.getPrice());
        existingMenu.setUnits(menuItem.getUnits());

        return menuItemRepository.save(existingMenu);
    }


    @Override
    public void deleteMenu(long menuId) {
        MenuItem existingMenu = menuItemRepository.findById(menuId)
                .orElseThrow(() -> new ResourceNotFoundException("Menu does not exist with the ID: " + menuId));

        menuItemRepository.delete(existingMenu);
    }


    @Override
    public List<MenuItem> searchMenuItems(String name) {
        // Implement the search logic here, e.g., using Spring Data JPA queries
        return menuItemRepository.findByNameContaining(name);
    }
}