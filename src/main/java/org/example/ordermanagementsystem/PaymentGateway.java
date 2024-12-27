package org.example.ordermanagementsystem;

public class PaymentGateway {
    public static boolean processpayment(double amount, String paymentMethod){
        return Math.random() > 0.1;
    }
}
