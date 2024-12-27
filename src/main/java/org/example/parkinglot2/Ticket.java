package org.example.parkinglot2;

import org.example.parkinglot2.vehicle.Vehicle;

import java.util.Date;

public class Ticket {
    private String id;
    private Date entryTime;
    private Date exitTime;
    private Vehicle vehicle;
    private ParkingSpot spot;

    public Ticket(String id, Vehicle vehicle, Date entryTime, ParkingSpot spot){
        this.entryTime = entryTime;
        this.id  = id;
        this.vehicle = vehicle;
        this.spot = spot;
    }

    public String getTicketId(){
        return this.id;
    }

    public Date getEntryTime(){
        return this.entryTime;
    }

    public Date getExitTime(){
        return this.exitTime;
    }

    public void  setExitTime(Date exitTime){
        this.exitTime = exitTime;
    }

    public ParkingSpot getSpot(){
        return this.spot;
    }
}
