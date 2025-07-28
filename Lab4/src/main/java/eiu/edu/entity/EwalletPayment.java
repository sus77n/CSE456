package eiu.edu.entity;

public class EwalletPayment implements PaymentMethod {
    @Override
    public void makePayment(double amount) {
        System.out.println("Paid $" + amount + " using Card.");
    }
}
