package org.example.deckofcards.models;

import lombok.Data;

@Data
public class Card {
    private final int id;
    private final Suits suit;
    private final CardValue value;

    public Card(int id, Suits suit, CardValue value){
        this.id = id;
        this.suit = suit;
        this.value  = value;
    }

    public String getCardSuitAndValue(){
        return value + " of " + suit;
    }
}
