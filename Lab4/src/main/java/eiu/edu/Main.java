package eiu.edu;

import eiu.edu.entity.EwalletPayment;
import eiu.edu.entity.PaymentMethod;
import eiu.edu.service.PaymentService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PaymentMethod method = new EwalletPayment(); // or CardPayment, BankTransferPayment
        PaymentService service = new PaymentService(method);
        service.process(100.0);
    }
}