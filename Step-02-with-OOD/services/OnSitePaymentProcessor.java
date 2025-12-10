public class OnSitePaymentProcessor implements PaymentProcessor {
    @Override
    public void pay(double amount) {
        System.out.println("Paid on site: " + amount);
    }
}