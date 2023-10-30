package com.techbridge.sams.club.menuItemOrder;




import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.awt.*;
import java.util.Date;
import java.util.List;

@Entity
public class MenuItemOrder {
    //fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    private String menuItem;
    private double price;

    private int quantityOrdered;


    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date orderDate;
    private boolean completed;




    //constructors


    public MenuItemOrder() {
    }

    public MenuItemOrder(String menuItem, double price, int quantityOrdered, Date orderDate, boolean completed) {
        this.menuItem = menuItem;
        this.price = price;
        this.quantityOrdered = quantityOrdered;
        this.orderDate = orderDate;
        this.completed = completed;
    }

    // getters and setters


    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(String menuItem) {
        this.menuItem = menuItem;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
