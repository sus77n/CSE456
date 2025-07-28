package eiu.edu.entity;

public class CardPayment implements PaymentMethod {
    @Override
    public void makePayment(double amount) {
        System.out.println("Paid $" + amount + " using Card.");
    }
}