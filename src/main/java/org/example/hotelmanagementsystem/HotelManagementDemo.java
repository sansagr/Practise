package org.example.hotelmanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class HotelManagementDemo {
    public static void main(String[] args) {

        Guest guest = new Guest(1, "Sanskar", "shilpitha", 25);
        HotelGenerator hotelGenerator = new HotelGenerator(4,6,"Hotel decent", 1);
        Hotel hotel = hotelGenerator.generateHotel();
        ReservationSystem reservationSystem = new ReservationSystem(hotel);

        List<Room> rooms = reservationSystem.getAvailableRooms(2, "Economy");
//        reservationSystem.reserveARoom();
        for (Room room : rooms) {
            System.out.println(room.getId());
        }
    }
}
