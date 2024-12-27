package org.example.hotelmanagementsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Hotel {
    private String name;
    private int id;
    private List<Floor> floors;

    public Hotel(String name, int id, List<Floor> floors){
        this.name = name;
        this.id = id;
        this.floors = floors;
    }

    public List<Floor> getFloors() {
        return floors;
    }

}
