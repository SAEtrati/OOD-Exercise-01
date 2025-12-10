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

    public void makeReservation(Reservation res){
        System.out.println("Processing reservation for " + res.customer.name);

        if(res.customer.city.equals("Paris")){
            System.out.println("Apply city discount for Paris!");
            res.room.price *= 0.9;
        }

        paymentProcessor.pay(res.totalPrice());

        System.out.println("----- INVOICE -----");
        System.out.println("hotel.Customer: " + res.customer.name);
        System.out.println("hotel.Room: " + res.room.number + " (" + res.room.type + ")");
        System.out.println("Total: " + res.totalPrice());
        System.out.println("-------------------");

        messageSender.send(res.customer.email, "Your reservation confirmed!");

    }
}