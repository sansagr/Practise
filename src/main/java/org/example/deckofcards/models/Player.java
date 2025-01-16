package org.example.deckofcards.models;

import java.util.List;

public class Player extends Participant{
    private final int id;
    public Player( int id) {
        this.id = id;
    }
    public int getPlayerId(){
        return id;
    }
}
