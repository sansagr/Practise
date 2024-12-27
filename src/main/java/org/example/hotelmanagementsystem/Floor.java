package org.example.hotelmanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private List<Room> rooms;
    private int floorNumber;

    public Floor(List<Room> rooms, int floorNumber){
        this.rooms = rooms;
        this.floorNumber = floorNumber;
    }


    public List<Room> getAllTheRooms(){
        return rooms;
    }
}
