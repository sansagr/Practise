package org.example.stadium;

import java.util.HashMap;

public class Cash implements Payment {
    private HashMap<Integer, Integer> cashBundle;

    public Cash(HashMap<Integer, Integer> cashBundle){
        this.cashBundle = cashBundle;
    }

    @Override
    public int getAmount(){
        int totalAmount = 0;
        for(HashMap.Entry<Integer, Integer> entry: cashBundle.entrySet() ){
            int denomination = entry.getKey();
            int count = entry.getValue();
            totalAmount += denomination*count;
        }
        return totalAmount;
    }

}
