package org.example.parkinglot2.PaymentStrategy;

import org.example.parkinglot2.Ticket;

public interface PaymentStrategy {
    public void processPayment(Ticket ticket);
}
