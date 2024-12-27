package org.example.parkinglot;

import org.example.parkinglot.vehicletype.Vehicle;
import org.example.parkinglot.vehicletype.VehicleType;

public class ParkingSpot {
    private final int spotNumber;
    private final VehicleType vehicleType;
    private Vehicle vehicle;

    public ParkingSpot(int spotNumber, VehicleType vehicleType){
        this.vehicleType = vehicleType;
        this.spotNumber = spotNumber;
    }

    public synchronized boolean isAvailable(){
        return vehicle == null;
    }

    public synchronized void parkVehicle(Vehicle vehicle){
        if(isAvailable() && vehicle.getType() == this.vehicleType){
            this.vehicle = vehicle;
        }
        else{
            throw new IllegalArgumentException("Invalid vehicle type or spot already occupied");
        }
    }

    public synchronized void unparkVehicle(){
        this.vehicle = null;
    }

    public VehicleType getVehicleType(){
        return this.vehicleType;
    }

    public Vehicle getParkedVehicle(){
        return this.vehicle;
    }

    public int getSpotNumber() {
        return spotNumber;
    }
}
