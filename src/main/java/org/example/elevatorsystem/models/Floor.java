package org.example.elevatorsystem.models;

import org.example.elevatorsystem.services.Direction;
import org.example.elevatorsystem.services.LiftRequestHandler;

public class Floor {
    private int number;
    private LiftRequestHandler liftService;

    public Floor(int number, LiftRequestHandler liftService){
        this.number = number;
        this.liftService = liftService;
    }

    public void callLift(Direction direction){
        liftService.callLift(number, direction);
    }
}
