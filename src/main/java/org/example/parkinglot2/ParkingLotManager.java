package org.example.parkinglot2;

import org.example.parkinglot2.coststrategy.CostStrategy;
import org.example.parkinglot2.coststrategy.CostStrategyFactory;
import org.example.parkinglot2.vehicle.Vehicle;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ParkingLotManager {
    private ParkingLot parkingLot;
    private Map<String, Ticket> activeTickets;

    public ParkingLotManager(String name, int floors, int spotsPerFloor) {
        this.parkingLot = ParkingLotCreator.createParkingLot(name, floors, spotsPerFloor);
        this.activeTickets = new HashMap<>();
    }

    public synchronized Ticket parkVehicle(Vehicle vehicle, SpotType type) {
        for (Floor floor : parkingLot.getFloors()) {
            ParkingSpot spot = floor.findSpot(type);

//            System.out.println(spot.getSpotNumber()  + " "+spot.isOccupied() + " "+ spot.getSpotType());
            if (!spot.isOccupied()) {
                spot.reserveSpot(vehicle);
                Ticket ticket = new Ticket(vehicle.getLicence(), vehicle, new Date(), spot);
                activeTickets.put(vehicle.getLicence(), ticket);
                return ticket;
            }
        }
        return null;
    }

    public synchronized void retrieveVehicle(String ticketId){
        Ticket ticket = activeTickets.remove(ticketId);
        if (ticket != null){
            ticket.setExitTime(new Date());
            ParkingSpot spot = ticket.getSpot();
            SpotType type = ticket.getSpot().getSpotType();
            CostStrategy costStrategy = CostStrategyFactory.getStrategy(type);
            double cost = costStrategy.calculateCost(ticket);
            System.out.println("Parking Fee: "+ cost);
            spot.freeSpot();
        }
    }
}
