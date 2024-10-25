package org.example.stadium;

import java.util.List;

public interface SeatReservation {
    void reserveASeat(Guest guest, Seat seat);
    void cancelReservation(Guest guest, Seat seat);
    List<Seat> listAvailableSeats(Stadium stadium);
}
