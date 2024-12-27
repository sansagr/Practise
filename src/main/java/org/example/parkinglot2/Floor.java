package org.example.parkinglot2;

import org.example.parkinglot2.parkingstrategy.ParkingStrategy;
import org.example.parkinglot2.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private List<ParkingSpot> parkingSpots;
    private int number;
    private ParkingStrategy strategy;

    public Floor(int number, List<ParkingSpot> parkingSpots, ParkingStrategy strategy){
        this.number = number;
        this.parkingSpots = parkingSpots;
        this.strategy = strategy;
    }

    public void addSpot(ParkingSpot spot){
        parkingSpots.add(spot);
    }

    public void setStrategy(ParkingStrategy strategy){
        this.strategy = strategy;
    }

    public ParkingSpot findSpot(SpotType type){
        return strategy.findSpot(parkingSpots, type);
    }
}
