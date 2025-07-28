package eiu.edu.presentation;

import eiu.edu.data.EwalletPayment;
import eiu.edu.data.PaymentMethod;
import eiu.edu.service.PaymentService;

public class Main {
    public static void main(String[] args) {
        PaymentMethod method = new EwalletPayment();

        PaymentService service = new PaymentService(method);

        service.processPayment(99.99);
    }
}
