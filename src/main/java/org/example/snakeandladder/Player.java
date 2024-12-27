package org.example.snakeandladder;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Player {
    private int id;
    private String colour;
    private int position;

    public Player(int id, String colour, int position){
        this.colour = colour;
        this.id = id;
        this.position = position;
    }

}
