package org.example.parkinglot2.parkingstrategy;

import org.example.parkinglot2.ParkingSpot;
import org.example.parkinglot2.SpotType;

import java.util.List;

public class NearestToEntranceStrategy implements ParkingStrategy {

    @Override
    public ParkingSpot findSpot(List<ParkingSpot> availableSpots, SpotType type) {
        return availableSpots.stream()
                .filter(spot->  !spot.isOccupied())
                .filter(spot-> type == spot.getSpotType())
                .findFirst()
                .orElse(null);
    }
}
