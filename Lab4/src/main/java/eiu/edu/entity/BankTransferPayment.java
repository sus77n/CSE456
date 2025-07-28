package eiu.edu.entity;

public class BankTransferPayment implements PaymentMethod {
    @Override
    public void makePayment(double amount) {
        System.out.println("Paid $" + amount + " using Card.");
    }
}
