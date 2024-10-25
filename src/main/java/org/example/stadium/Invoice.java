package org.example.stadium;

import java.time.LocalDateTime;

public class Invoice {
    private int amount;
    private int id;
    private LocalDateTime timestamp;
    private Guest guest;
    private Seat seat;

    public Invoice(Seat seat, int amount, int id, LocalDateTime timestamp, Guest guest){
        this.amount = amount;
        this.id = id;
        this.timestamp = timestamp;
        this.guest = guest;
        this.seat = seat;
    }

    public String printInvoice(){
        return "your invoice for SeatId" +seat.getId() + " amount: " + amount + " guest id: " + guest.getId() +" guest name: " + guest.getName()+ " timestamp: " + timestamp;
    }

    public int getAmount(){
        return amount;
    }

    public Guest getGuest(){
        return guest;
    }

    public Seat getSeat(){
        return seat;
    }
}
