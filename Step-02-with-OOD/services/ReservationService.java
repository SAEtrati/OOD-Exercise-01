package services;

import constants.Notifier;
import constants.PaymentMethods;

public class ReservationService {
    private final PaymentProcessor paymentProcessor;
    private final MessageSender messageSender;

    public ReservationService(PaymentProcessor paymentProcessor, MessageSender messageSender) {
    this.paymentProcessor = paymentProcessor;
    this.messageSender = messageSender;
    }

    public void makeReservation(Reservation res) {
        System.out.println("Processing reservation for " + res.customer.name);

        res.applyCityDiscount();

        paymentProcessor.pay(res.totalPrice());

        res.printInvoice();

        messageSender.send(res.customer,"Your reservation confirmed!");
    }
}