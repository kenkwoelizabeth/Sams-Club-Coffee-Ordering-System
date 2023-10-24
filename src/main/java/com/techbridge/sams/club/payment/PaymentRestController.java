package com.techbridge.sams.club.payment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PaymentRestController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment")
    public Payment saveMenu(@RequestBody Payment payment) {

        return paymentService.savePayment(payment);
    }

    @GetMapping("/my_payments")
    public List<Payment> getMenus() {

        return paymentService.getAllPayment();

    }

    @GetMapping("/payment/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable(value = "id") long paymentId) {
        Payment existingPayment =paymentService.getPaymentById(paymentId);

        return ResponseEntity.ok(existingPayment);
    }

    @PutMapping("/payment/{id}")
    public String updatePayment(@PathVariable("id") long paymentId, @RequestBody Payment payment) {
        paymentService.updatePayment(paymentId, payment);
        return "redirect:/myPayment";
    }

    @DeleteMapping("/payments/{id}")
    public String deleteStore(@PathVariable("id") long paymentId) {
        paymentService.deletePayment(paymentId);
        return "redirect:/payments";
    }



}
