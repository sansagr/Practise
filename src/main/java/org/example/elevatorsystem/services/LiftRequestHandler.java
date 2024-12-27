package org.example.elevatorsystem.services;

public class LiftRequestHandler {
    private LiftMoverService moverService;
    public LiftRequestHandler(LiftMoverService moverService){
        this.moverService = moverService;
    }
    public void callLift(int floor, Direction direction){
        moverService.addInstruction(floor, direction);
    }
}
