package eiu.edu.data;

public class BankTransferPayment implements PaymentMethod {
    @Override
    public void makePayment(double amount) {
        System.out.println("Paid $" + amount + " using Bank Transfer.");
    }
}
