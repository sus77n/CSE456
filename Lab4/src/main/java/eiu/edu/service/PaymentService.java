package eiu.edu.service;

import eiu.edu.entity.PaymentMethod;

public class PaymentService {
    private final PaymentMethod paymentMethod;

    public PaymentService(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void process(double amount) {
        paymentMethod.makePayment(amount);
    }
}
