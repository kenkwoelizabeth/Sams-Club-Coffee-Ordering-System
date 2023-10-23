package com.techbridge.sams.club.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment savePayment(Payment payment) {
        return null;
    }

    @Override
    public List<Payment> getAllPayment() {
        return null;
    }

    @Override
    public Payment getPaymentById(long paymentId) {
        return null;
    }

    @Override
    public Payment updatePayment(long paymentId, Payment payment) {
        return null;
    }

    @Override
    public void deletePayment(long paymentId) {

    }
}
    private long paymentId;
    private double paymentAmount;
    private LocalDate paymentDate;
    private boolean isCompleted;