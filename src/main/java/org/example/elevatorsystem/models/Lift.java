package org.example.elevatorsystem.models;

import lombok.Data;
import org.example.elevatorsystem.services.Direction;

import java.util.Set;

@Data
public class Lift {
    int id;
    int currentFloor;
    Direction direction;
    Set<Integer> upQueue;
    Set<Integer> downQueue;
    LiftState state;

    public void move() {
        while (true) {
                if (direction == Direction.UP && !upQueue.isEmpty()){

                }
        }
    }

    ;

    public void addStop(int floor) {

    }

    ;
}
