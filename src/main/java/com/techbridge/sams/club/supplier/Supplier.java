package com.techbridge.sams.club.supplier;


import com.techbridge.sams.club.menuItem.MenuItem;

import javax.persistence.*;
import java.util.List;

@Entity
public class Supplier {
    // fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long supplierId;
    private String name;
    private String location;
    private String phoneNumber;


    //constructors

    public Supplier() {
    }

    public Supplier(String name, String location, String phoneNumber) {
        this.name = name;
        this.location = location;
        this.phoneNumber = phoneNumber;
    }

//getters and setters


    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
