import constants.PaymentMethods;
import models.Customer;
import models.LuxuryRoom;
import constants.Notifier;
import services.Reservation;
import models.Room;
import services.ReservationService;

public class Main {
    public static void main(String[] args){
        Customer customer = new Customer("Ali", "ali@example.com","09124483765", "Paris");
        Room room = new LuxuryRoom("203", 150);
        Reservation res = new Reservation(room, customer, 2);

        // Tests for new features
        PaymentProcessor paymentProcessor = new OnSitePaymentProcessor();
        MessageSender messageSender = new SMSSender();

        ReservationService service = new ReservationService(paymentProcessor, messageSender);
        service.makeReservation(res);
    }
}