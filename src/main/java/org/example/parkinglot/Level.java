package org.example.parkinglot;

import org.example.parkinglot.vehicletype.Vehicle;
import org.example.parkinglot.vehicletype.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private final int floor;
    private final List<ParkingSpot> parkingSpots;

    public Level(int floor, int numSpots) {
        this.floor = floor;
        parkingSpots = new ArrayList<>(numSpots);

        double spotsForBike = 0.50;
        double spotsForCar = 0.40;

        int numBikes = (int) (numSpots * spotsForBike);
        int numCars = (int) (numSpots * spotsForCar);

        for (int i = 1; i <= numBikes; i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.MOTORCYCLE));
        }

        for (int i = numBikes + 1; i <= numBikes + numCars; i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.CAR));
        }

        for (int i = numBikes + numCars + 1; i <= numSpots; i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.TRUCK));
        }
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isAvailable() && spot.getVehicleType() == vehicle.getType()) {
                spot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unparkVehicle(Vehicle vehicle){
        for (ParkingSpot spot: parkingSpots){
            if(!spot.isAvailable() && spot.getParkedVehicle().equals(vehicle)){
                spot.unparkVehicle();
                return true;
            }
        }
        return false;
    }

    public void displayAvailability(){
        System.out.println("Level "+ this.floor + " Availability");
        for (ParkingSpot spot: parkingSpots){
            System.out.println("Spot " + spot.getSpotNumber() + ": " + (spot.isAvailable() ? "Available for": "Occupied by") + " " + spot.getVehicleType());
        }
    }


}
