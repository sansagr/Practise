package org.example.parkinglot2;

import org.example.parkinglot2.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static ParkingLot instance;
    private String name;
    private List<Floor> floors;

    private ParkingLot(String name){
        this.name = name;
        this.floors = new ArrayList<>();
    }

    public static synchronized ParkingLot getInstance(String name){
        if (instance == null){
            instance = new ParkingLot(name);
        }
        return instance;
    }

    public void addFloor(Floor floor){
        this.floors.add(floor);
    }

    public List<Floor> getFloors(){
        return this.floors;
    }
}
