package org.example.elevatorsystem.controllers;

import org.example.elevatorsystem.services.LiftRequestHandler;
import org.example.elevatorsystem.services.LiftMoverService;

public class FloorSelectionController {
    private LiftRequestHandler liftService;
    private LiftMoverService liftMover;

    public FloorSelectionController(LiftRequestHandler liftService, LiftMoverService liftMover){
        this.liftMover = liftMover;
        this.liftService = liftService;
    }
}
