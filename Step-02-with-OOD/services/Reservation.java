package services;

import models.Customer;
import models.Room;

public class Reservation {
    public Room room;
    public Customer customer;
    public int nights;

    public Reservation(Room r, Customer c, int nights) {
        this.room = r;
        this.customer = c;
        this.nights = nights;
    }
    public double totalPrice(){
        return room.price * nights;
    }
    public void applyCityDiscount() {
        if (customer.city.equals("Paris")) {
            System.out.println("Apply city discount for Paris!");
            room.price *= 0.9;
        }
    }
    public void printInvoice() {
        System.out.println("----- INVOICE -----");
        System.out.println("Customer: " + customer.name);
        System.out.println("Room: " + room.number + " (" + room.type + ")");
        System.out.println("Total: " + totalPrice());
        System.out.println("-------------------");
    }
}