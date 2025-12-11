package services;

public class SMSSender implements MessageSender {
    @Override
    public void send(models.Customer customer, String message) {
        System.out.println("Sending SMS to " + customer.mobile + ": " + message);
    }
}