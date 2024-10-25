package org.example.stadium;

public interface PaymentProcessor<T> {
    public T processPayment(Invoice invoice, Payment payment);
}
