package org.example.hotelmanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class ReservationSystem {
    private Hotel hotel;

    public ReservationSystem(Hotel hotel){
        this.hotel = hotel;
    }
    public void reserveARoom(Room room, Guest guest){
        room.bookRoom(guest);
        guest.setRoom(room);
    }

    public void cancelReservation(Guest guest){
        Room room = guest.getRoom();
        guest.setRoom(null);
        room.cancelRoom();
    }

    public List<Room> getAvailableRooms(int capacity, String type){
        List<Room> availableRooms = new ArrayList<>();
        for(Floor floor: this.hotel.getFloors()){
            for( Room room: floor.getAllTheRooms()){
                if (!room.isRoomOccupied() && room.getCapacity() >= capacity && room.getType().equals(type)){
                    availableRooms.add(room);
                }
            }
        }
        return availableRooms;
    }
}
