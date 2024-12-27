package org.example.parkinglot2.vehicle;

public abstract class Vehicle {
    private String licence;
    private VehicleType type;

    public Vehicle(String licence, VehicleType type) {
        this.licence = licence;
        this.type = type;
    }

    public VehicleType getType() {
        return this.type;
    }

    public String getLicence() {
        return this.licence;
    }
}
