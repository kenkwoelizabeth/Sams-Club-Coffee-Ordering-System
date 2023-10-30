package com.techbridge.sams.club.menuItem;


import com.techbridge.sams.club.menuItemOrder.MenuItemOrder;

import javax.persistence.*;

@Entity
public class MenuItem {
    // fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long menuId;
    private String name;
    private String description;
    private double price;

    private int quantityAvailable;
    private String units;


    // constructor


    public MenuItem() {
    }

    public MenuItem(String name, String description, double price, int quantityAvailable, String units) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
        this.units = units;
    }
//getters and setters


    public long getMenuId() {
        return menuId;
    }

    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }


}
