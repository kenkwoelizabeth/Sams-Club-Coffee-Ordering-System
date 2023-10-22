package com.techbridge.sams.club.menuItem;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class MenuItem {
    // fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long menuId;
    private String name;
    private double menuPrice;
    private String category;


    // constructor


    public MenuItem() {
    }

    public MenuItem(String name, double menuPrice, String category) {
        this.name = name;
        this.menuPrice = menuPrice;
        this.category = category;
    }

    //getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(double menuPrice) {
        this.menuPrice = menuPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
