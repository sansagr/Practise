package org.example.stadium;

public class Seat {
    private int id;
    private boolean isReserved;
    private int amount;

    public Seat(int id, int amount){
        this.id = id;
        this.amount = amount;
        this.isReserved = false;
    }

    public int getId(){
        return id;
    }

    public int getAmount(){
        return amount;
    }

    public boolean isReserved(){
        return isReserved;
    }

    public void reserveSeat(){
        isReserved = true;
    }

    public void releaseSeat(){
        isReserved = false;
    }
}
