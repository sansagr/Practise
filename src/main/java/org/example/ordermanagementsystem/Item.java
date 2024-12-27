package org.example.ordermanagementsystem;

public class Item {
    private int id;
    private String name;
    private double cost;

    public Item(int id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public int getId() {
        return this.id;
    }


    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getName() {
        return this.name;
    }
}
