package org.example.elevatorsystem.models;

import org.example.elevatorsystem.services.Direction;

public class Instruction {
    private int floor;
    private Direction direction;

    public Instruction(int floor, Direction direction){
        this.floor = floor;
        this.direction = direction;
    }

    public int getFloor(){
        return this.floor;
    }
}
