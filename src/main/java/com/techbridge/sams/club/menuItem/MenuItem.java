package com.techbridge.sams.club.menuItem;


import com.techbridge.sams.club.order.Order;

import javax.persistence.*;

@Entity
public class MenuItem {
    // fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long menuId;
    private String name;
    private double menuPrice;
    private String category;

    @ManyToOne(targetEntity = Order.class, fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private Order order;
    // constructor


    public MenuItem() {
    }

    public MenuItem(String name, double menuPrice, String category, Order order) {
        this.name = name;
        this.menuPrice = menuPrice;
        this.category = category;
        this.order = order;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
