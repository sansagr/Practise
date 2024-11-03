package org.example.snakeandladder;

import lombok.Data;

public class Player {
    private int id;
    private String colour;
    private Cell position;

    public Player(int id, String colour, Cell position){
        this.colour = colour;
        this.id = id;
        this.position = position;
    }

}
