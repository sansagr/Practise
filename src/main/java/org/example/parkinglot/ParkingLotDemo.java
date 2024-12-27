package org.example.parkinglot;

import org.example.parkinglot.vehicletype.Car;
import org.example.parkinglot.vehicletype.MotorCycle;
import org.example.parkinglot.vehicletype.Truck;
import org.example.parkinglot.vehicletype.Vehicle;

public class ParkingLotDemo {
    public static void main(String[] args){
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addLevel(new Level(1, 100));
        parkingLot.addLevel(new Level(2, 80));

        Vehicle car = new Car("ABS123");
        Vehicle truck = new Truck("XYZ234");
        Vehicle motorcycle = new MotorCycle("NJN123");

        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(truck);
        parkingLot.parkVehicle(motorcycle);

        parkingLot.displayAvailability();

        parkingLot.unparkVehicle(truck);

        parkingLot.displayAvailability();
    }
}
