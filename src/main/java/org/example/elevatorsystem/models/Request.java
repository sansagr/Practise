package org.example.elevatorsystem.models;

import org.example.elevatorsystem.services.Direction;

public class Request {
    int sourceFloor;
    int destinationFloor;
    Direction direction;

    public Request(int sourceFloor, int destinationFloor){
        this.sourceFloor = sourceFloor;
        this.destinationFloor = destinationFloor;
        this.direction = sourceFloor < destinationFloor ? Direction.DOWN : Direction.UP;
    }
}
