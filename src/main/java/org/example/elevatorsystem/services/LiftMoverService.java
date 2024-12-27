package org.example.elevatorsystem.services;

import org.example.elevatorsystem.models.Instruction;
import org.example.elevatorsystem.models.Lift;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LiftMoverService {
    private Queue<Instruction> instructions;
    private Lift lift;

    public LiftMoverService(Lift lift){
        this.instructions = new LinkedList<>();
        this.lift = lift;
    }

    public void addInstruction(int floor, Direction direction){
        Instruction instruction = new Instruction(floor, direction);
        this.instructions.add(instruction);
    }

//    public void processInstructions(){
//        while(!instructions.isEmpty()){
//            Instruction instruction = instructions.poll();
//            int floor = instruction.getFloor();
//            lift.setCurrentFloor(floor);
//        }
//    }
}
