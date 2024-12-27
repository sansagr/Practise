package org.example.parkinglot2.parkingstrategy;

import org.example.parkinglot2.ParkingSpot;
import org.example.parkinglot2.SpotType;

import java.util.List;

public interface ParkingStrategy {
    ParkingSpot findSpot(List<ParkingSpot> availableSpots, SpotType type);
}
