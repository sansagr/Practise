package org.example.hotelmanagementsystem;

public class Guest {
    private int id;
    private String name;
    private String address;
    private int age;
    private Room room;

    public Guest(int id, String name, String address, int age){
        this.name = name;
        this.address = address;
        this.age = age;
        this.id = id;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Room getRoom(){
        return this.room;
    }
}
