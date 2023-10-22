package com.techbridge.sams.club.payment;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

public class Payment {
    // fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paymentId;
    private double paymentAmount;
    private LocalDate paymentDate;
    private boolean isCompleted;

    //constructors

    public Payment() {
    }


    public Payment(double paymentAmount, LocalDate paymentDate, boolean isCompleted) {
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;
        this.isCompleted = isCompleted;
    }

    //getters and setters


    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
