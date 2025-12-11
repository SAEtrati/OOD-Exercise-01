package services;

public interface MessageSender {
    void send(models.Customer customer, String message);
}