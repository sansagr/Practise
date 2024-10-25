package org.example.stadium;

import java.util.HashMap;
public class CashPaymentProcessor implements PaymentProcessor{


    public Cash processPayment(Invoice invoice, Payment payment) {
        if (!(payment instanceof Cash)) {
            throw new IllegalArgumentException("Invalid payment type for CashPaymentProcessor");
        }
        Cash cash = (Cash) payment;
        int amountToPay = invoice.getAmount();
        int cashReceived = cash.getAmount();

        int refund = cashReceived - amountToPay;
        System.out.println("The amount you get back is: " + refund);

        HashMap<Integer, Integer> refundCashBundle = new HashMap<>();
        refundCashBundle.put(100, refund / 100); // Simplified logic to return refund in 100 notes
        return new Cash(refundCashBundle);
    }
}
