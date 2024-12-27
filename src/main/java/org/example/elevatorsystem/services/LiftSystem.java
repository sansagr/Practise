package org.example.elevatorsystem.services;

import org.example.elevatorsystem.models.Lift;
import org.example.elevatorsystem.models.LiftState;

import java.util.List;

public class LiftSystem {
    List<Lift> lifts;
    int totalFLoors;

    void requestLift(int currentFloor, Direction direction) {
        Lift bestlift = null;
        int minDistance = Integer.MAX_VALUE;

        for (Lift lift : lifts) {
            if (lift.getState() == LiftState.MAINTENANCE) continue;

            int distance = Math.abs(lift.getCurrentFloor() - currentFloor);
            if (lift.getDirection() == Direction.IDLE ||
                    (lift.getDirection() == direction
                            && ((direction == Direction.UP && lift.getCurrentFloor() <= currentFloor) ||
                            (direction == Direction.DOWN && lift.getCurrentFloor() >= currentFloor)))) {
                if (distance < minDistance){
                    bestlift  = lift;
                    minDistance = distance;
                }
            }
        }

        if (bestlift != null){
            bestlift.addStop(currentFloor);
        }else{
//            que
        }
    }

    ;

    void processRequest() {

    }

}
