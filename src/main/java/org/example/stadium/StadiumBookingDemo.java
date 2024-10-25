package org.example.stadium;

import java.time.LocalDateTime;
import java.util.List;

public class StadiumBookingDemo {
   public static void main(String[] args) {
        Seat seat1 = new Seat(1, 50);
        Seat seat2 = new Seat(2, 100);

       Seat seat3 = new Seat(3, 50);
       Seat seat4 = new Seat(4, 100);
        Section section1 = new Section(1,List.of(seat1, seat2));
        Section section2 = new Section(2,List.of(seat3, seat4));

        Stadium stadium = new Stadium(List.of(section1, section2));

        Guest guest = new Guest("sansky", 1);

        guest.reserveASeat(guest, seat1);

        LocalDateTime timestamp  =  LocalDateTime.now();
        Invoice invoice = new Invoice(seat1, seat1.getAmount(), 1, timestamp, guest );

        System.out.println(invoice.printInvoice());


       List<Seat> availableSeats = guest.listAvailableSeats(stadium);

        for(Seat seat: availableSeats) {
            System.out.println("Available Seats" + seat.getId());
        }
        guest.cancelReservation(guest,seat1);
       List<Seat> availableSeats2 = guest.listAvailableSeats(stadium);
       for(Seat seat: availableSeats2) {
           System.out.println("Available Seats" + seat.getId());
       }

    }
}
