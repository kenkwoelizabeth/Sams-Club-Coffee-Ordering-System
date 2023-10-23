package com.techbridge.sams.club.menuItem;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuItemService {

    public MenuItem saveMenu(MenuItem menuItem);

    public List<MenuItem> getAllMenu();


    public MenuItem getMenuById(long menuId);
    public MenuItem updateMenu(long MenuId, MenuItem menuItem);

    public void deleteMenu(long menuId) ;
    }