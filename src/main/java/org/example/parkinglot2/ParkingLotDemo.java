package org.example.parkinglot2;

import org.example.parkinglot2.vehicle.Car;
import org.example.parkinglot2.vehicle.Truck;
import org.example.parkinglot2.vehicle.Vehicle;

import java.util.concurrent.TimeUnit;

public class ParkingLotDemo {
    public static void main(String[] args) throws InterruptedException {
        ParkingLotManager parkingLotManager = new ParkingLotManager("Take me to church", 4, 100);

        Vehicle car = new Car("abc124");
        Vehicle truck = new Truck("dffq123");

        Ticket ticket1 =  parkingLotManager.parkVehicle(car,SpotType.COMPACT);
        Ticket ticket2 =  parkingLotManager.parkVehicle(truck,SpotType.LARGE);


        parkingLotManager.retrieveVehicle(ticket1.getTicketId());
        parkingLotManager.retrieveVehicle(ticket2.getTicketId());

        Ticket ticket3 = parkingLotManager.parkVehicle(car, SpotType.COMPACT);
        parkingLotManager.retrieveVehicle(ticket3.getTicketId());



    }
}
