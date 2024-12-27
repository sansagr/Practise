package org.example.hotelmanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class HotelGenerator {
    private int noOfFloors;
    private int noOfRoomOnFloor;
    private String name;
    private int id;

    public HotelGenerator(int noOfFloors, int noOfRoomOnFloor, String name, int id){
        this.noOfFloors = noOfFloors;
        this.noOfRoomOnFloor = noOfRoomOnFloor;
        this.name = name;
        this.id = id;
    }

    public Hotel generateHotel(){
        List<Floor> floors = new ArrayList<>();
        for (int i = 0; i< this.noOfFloors; i++){
            List<Room> rooms = new ArrayList<>();
            for (int j = 0; j< this.noOfRoomOnFloor; j++){
                String roomId = i + Integer.toString(j);
                String type = "Economy";
                int capacity = 2;
                Room room = new Room(roomId, type, capacity);
                rooms.add(room);
            }
            floors.add(new Floor(rooms, i));
        }
        return new Hotel(this.name,this.id, floors);
    }
}
