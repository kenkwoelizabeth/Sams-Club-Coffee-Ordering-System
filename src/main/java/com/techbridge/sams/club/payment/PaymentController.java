package com.techbridge.sams.club.payment;

import com.techbridge.sams.club.order.Order;
import com.techbridge.sams.club.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
@Controller
public class PaymentController {
    @Autowired
    private PaymentService paymentService;



    @GetMapping("/payment")
    public String getAllPayment(Model model) {
        model.addAttribute("listPayments", paymentService.getAllPayment());
        return "payment/payment_list";
    }


    @GetMapping("/my_payments")
    public String getMyPayments(Model model) {
        // create model attribute to bind form data
        Payment payment  = new Payment();
        model.addAttribute("payment", payment);
        return "payment/new_payment";
    }

    @PostMapping("/savePayment")
    public String savePayment(@ModelAttribute("order") @Valid Payment payment ,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "payment/new_payment";
        }
        // save menu to database
       paymentService.savePayment(payment);
        return "redirect:/payment";
    }

    @GetMapping("/my_payments/{id}")
    public String getPaymentsById(@PathVariable(value = "id") int paymentId, Model model) {

        Payment payment  = paymentService.getPaymentById(paymentId);
        model.addAttribute("payment", payment);

        return "payment/update_payment";
    }

    @GetMapping("/deletePayment/{id}")
    public String deletePayment(@PathVariable(value = "id") int paymentId) {
        this.paymentService.deletePayment(paymentId);

        return "redirect:/payment";
    }
}
