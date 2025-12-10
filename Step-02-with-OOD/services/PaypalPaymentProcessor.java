public class PaypalPaymentProcessor implements PaymentProcessor {
    @Override
    public void pay(double amount) {
        System.out.println("Paid by PayPal: " + amount);
    }
}