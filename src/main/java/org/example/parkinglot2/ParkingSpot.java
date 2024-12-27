package org.example.parkinglot2;

import org.example.parkinglot2.vehicle.Vehicle;
import org.example.parkinglot2.vehicle.VehicleType;

public class ParkingSpot {
    private String number;
    private boolean isOccupied;
    private Vehicle vehicle;
    private SpotType type;

    public ParkingSpot(String number,SpotType type){
        this.number = number;
        this.isOccupied = false;
        this.type = type;
    }

    public boolean isOccupied(){
        return this.isOccupied;
    }


    public void reserveSpot(Vehicle vehicle){
        this.isOccupied = true;
        this.vehicle = vehicle;
    }

    public String getSpotNumber(){
        return this.number;
    }

    public void freeSpot(){
        this.isOccupied = false;
        this.vehicle = null;
    }

    public SpotType getSpotType(){
        return this.type;
    }
}
