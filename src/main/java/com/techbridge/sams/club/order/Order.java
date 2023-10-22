package com.techbridge.sams.club.order;

import com.techbridge.sams.club.menuItem.MenuItem;
import com.techbridge.sams.club.payment.Payment;
import org.apache.tomcat.jni.Address;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
public class Order {
    //fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;
    private String customerFirstName;

    private String customerLastName;

    private String deliveryAddress;

    private String customerPhone;

    private String deliveryOption;

    private String location;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;

    @DateTimeFormat(pattern="HH:mm")
    @Temporal(TemporalType.TIME)
    private Date readyTime;

    private double subTotal;

    private double tax;

    private double total;


    @OneToMany(targetEntity = MenuItem.class,
            fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<MenuItem> menuItems;


    @OneToOne(targetEntity = Payment.class,
    fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private Payment payment;

    //constructors


    public Order() {
    }

    public Order(String customerFirstName, String customerLastName, String deliveryAddress, String customerPhone,
                 String deliveryOption, String location, Date deliveryDate, Date readyTime, double subTotal,
                 double tax, double total, List<MenuItem> menuItems, Payment payment) {
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.deliveryAddress = deliveryAddress;
        this.customerPhone = customerPhone;
        this.deliveryOption = deliveryOption;
        this.location = location;
        this.deliveryDate = deliveryDate;
        this.readyTime = readyTime;
        this.subTotal = subTotal;
        this.tax = tax;
        this.total = total;
        this.menuItems = menuItems;
        this.payment = payment;
    }


    // getters and setters


    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getDeliveryOption() {
        return deliveryOption;
    }

    public void setDeliveryOption(String deliveryOption) {
        this.deliveryOption = deliveryOption;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getReadyTime() {
        return readyTime;
    }

    public void setReadyTime(Date readyTime) {
        this.readyTime = readyTime;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    // ------------ custom methods start here ------------
    public String getSubTotalDisplay() {
        return String.format("$%.2f", getSubTotal());
    }

    public String getTaxDisplay() {
        return String.format("$%.2f", getTax());
    }

    public String getTotalDisplay() {
        return String.format("$%.2f", getTotal());
    }
}
