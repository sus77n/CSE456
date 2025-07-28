package eiu.edu.service;

import eiu.edu.data.PaymentMethod;

public class PaymentService {
    private PaymentMethod paymentMethod;

    public PaymentService(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void processPayment(double amount) {
        paymentMethod.makePayment(amount);
    }
}