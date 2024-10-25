package org.example.stadium;

import java.util.ArrayList;
import java.util.List;

public class Section {
    private int id;
    private List<Seat> seats;

    public Section(int id, List<Seat> seats){
        this.id = id;
        this.seats = seats;
    }

    public int getId(){
        return id;
    }

    public List<Seat> getSeats(){
        return seats;
    }
}
