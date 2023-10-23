package com.techbridge.sams.club.payment;



import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface PaymentService {
    public Payment savePayment(Payment payment);

    public List<Payment> getAllPayment();


    public Payment getPaymentById(long paymentId);
    public Payment  updatePayment(long paymentId, Payment payment);

    public void deletePayment(long paymentId) ;
}

