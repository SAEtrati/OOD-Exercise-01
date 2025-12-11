package services;

public class EmailSender implements MessageSender {
    @Override
    public void send(models.Customer customer, String message) {
        System.out.println("Sending email to " + customer.email + ": " + message);
    }
}