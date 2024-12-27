package org.example.parkinglot2.coststrategy;

import org.example.parkinglot2.Ticket;

public interface CostStrategy {

    public double calculateCost(Ticket ticket);
}
