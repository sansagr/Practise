package org.example.snakeandladder;


public class Player {
    private int id;
    private String colour;
    private int position;

    public Player(int id, String colour, int position){
        this.colour = colour;
        this.id = id;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public String getColour() {
        return colour;
    }

    public int getPosition() {
        return position;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
