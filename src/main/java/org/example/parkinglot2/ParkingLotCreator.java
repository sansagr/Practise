package org.example.parkinglot2;

import org.example.parkinglot2.parkingstrategy.NearestToEntranceStrategy;
import org.example.parkinglot2.parkingstrategy.ParkingStrategy;
import org.example.parkinglot2.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotCreator {


    public static ParkingLot createParkingLot(String name,int numFloors, int numVehiclePerFloor){
        ParkingLot parkingLot = ParkingLot.getInstance(name);

        for (int i = 1; i <= numFloors; i++){
            Floor floor = createParkingFloor(i,numVehiclePerFloor );
            parkingLot.addFloor(floor);
        }

        return parkingLot;
    }

    private static Floor createParkingFloor(int floorNumber, int spotsPerFloor){
        List<ParkingSpot> spots = new ArrayList<>();

        for (int i = 1 ;i <= spotsPerFloor ;i ++){
            SpotType type;

            if (i%10==0){
                type = SpotType.HANDICAPPED;
            }
            else if (i%5 == 0){
                type = SpotType.LARGE;
            }
            else if(i%2 == 0){
                type = SpotType.MOTORCYCLE;
            }
            else{
                type = SpotType.COMPACT;
            }
            spots.add(new ParkingSpot(floorNumber+ "-"+i, type));
        }
        ParkingStrategy strategy = new NearestToEntranceStrategy();
        return new Floor(floorNumber, spots, strategy);

    }


}
