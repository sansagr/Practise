package org.example.hotelmanagementsystem;

public class Room {
    private String id;
    private String type;
    private int capacity;
    private boolean isOccupied;
    private Guest guest;

    public Room(String id, String type, int capacity){
        this.id = id;
        this.type = type;
        this.isOccupied = false;
        this.capacity = capacity;
    }

    public void bookRoom(Guest guest){
        this.isOccupied = true;
        this.guest = guest;
    }

    public void cancelRoom(){
        this.isOccupied = false;
        this.guest = null;
    }

    public boolean isRoomOccupied(){
        return this.isOccupied;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public String getType(){
        return this.type;
    }

    public String getId(){
        return this.id;
    }
}
