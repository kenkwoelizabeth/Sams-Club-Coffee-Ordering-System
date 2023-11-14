package com.techbridge.sams.club.configuration;


import com.techbridge.sams.club.menuitem.MenuItemRepository;
import com.techbridge.sams.club.menuitem.MenuItemService;
import com.techbridge.sams.club.menuitem.MenuItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    // Make this a manually created bean to satisfy the capstone requirement
    @Bean
    @Autowired
    public MenuItemService menuItemService(MenuItemRepository menuItemRepository) {
        return new MenuItemServiceImpl(menuItemRepository);
    }
}
