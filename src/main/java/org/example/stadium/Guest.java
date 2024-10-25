package org.example.stadium;

import java.util.ArrayList;
import java.util.List;

public class Guest extends Person implements SeatReservation{
    private String name;
    private int id;

    public Guest(String name, int id){
        super(name, id);
    }

    @Override
    public void reserveASeat(Guest guest, Seat seat) {
        if(!seat.isReserved()){
            seat.reserveSeat();
            System.out.println("Seat is reserved by:" + guest.getName());
        }
        else{
            System.out.println("Seat is already reserved");
        }
    }

    @Override
    public void cancelReservation(Guest guest, Seat seat) {
        if (seat.isReserved()){
            seat.releaseSeat();
            System.out.println("Seat reservation cancelled by guest");
        }
    }

    @Override
    public List<Seat> listAvailableSeats(Stadium stadium) {
        List<Seat> availableSeats = new ArrayList<>();
        for(Section section: stadium.getSections()){
            for(Seat seat: section.getSeats()){
                if (!seat.isReserved()){
                    availableSeats.add(seat);
                }
            }
        }
        return availableSeats;
    }

}
