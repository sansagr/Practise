package org.example.elevatorsystem.services;

import org.example.elevatorsystem.models.Lift;

public class UserRequestProcessor {
    private LiftMoverService moverService;
    private Lift lift;

    public UserRequestProcessor(LiftMoverService moverService){
        this.moverService = moverService;
    }

    public void goToFloor(int floor) {
        int currentFloor = lift.getCurrentFloor();
        if (floor - currentFloor < 0) {
            moverService.addInstruction(floor, Direction.DOWN);
        } else if (floor - currentFloor > 0) {
            moverService.addInstruction(floor, Direction.UP);
        } else {
            moverService.addInstruction(floor, Direction.IDLE);
        }
    }

}
