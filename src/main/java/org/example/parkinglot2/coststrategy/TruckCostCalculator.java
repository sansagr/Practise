package org.example.parkinglot2.coststrategy;

import org.example.parkinglot2.Ticket;

import java.util.Date;

public class TruckCostCalculator implements CostStrategy{

    @Override
    public double calculateCost(Ticket ticket){
        Date exitTime = ticket.getExitTime();
        Date entryTime = ticket.getEntryTime();
        long duration = (exitTime.getTime() - entryTime.getTime()) /(1000* 60*60);
        if (duration <= 1) return 6.0;
        if (duration <=3 ) return 6.0 + (duration - 1)*5.5;
        return 6.0 + 11.0 + (duration - 3) * 4.5;
    }
}
