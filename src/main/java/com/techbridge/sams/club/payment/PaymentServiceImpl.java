package com.techbridge.sams.club.payment;


import com.techbridge.sams.club.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getAllPayment() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(long paymentId) {
        return paymentRepository.findById(paymentId)
                .orElseThrow(() -> new ResourceNotFoundException("Payment does not exist with the ID: " + paymentId));
    }

    @Override
    public Payment updatePayment(long paymentId, Payment payment) {
       Payment existingPayment= paymentRepository.findById(paymentId)
                .orElseThrow(() -> new ResourceNotFoundException("Payment does not exist with the ID: " + paymentId));
    existingPayment.setPaymentAmount(payment.getPaymentAmount());
        existingPayment.setPaymentDate(payment.getPaymentDate());
        existingPayment.setCompleted(payment.isCompleted());

        return  paymentRepository.save(existingPayment);
    }

    @Override
    public void deletePayment(long paymentId) {
        Payment existingPayment= paymentRepository.findById(paymentId)
                .orElseThrow(() -> new ResourceNotFoundException("Payment does not exist with the ID: " + paymentId));
paymentRepository.delete(existingPayment);
    }
}
