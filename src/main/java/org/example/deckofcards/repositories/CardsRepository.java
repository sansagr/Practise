package org.example.deckofcards.repositories;

import org.example.deckofcards.models.Card;

import java.util.*;
import java.util.Random;

public class CardsRepository {
    private final List<Card> deck;

    public CardsRepository(List<Card> cards){
        this.deck = cards;

    }

    public void addCard(Card card){
        deck.add(card);
    }

    public Card getTop(){
        return deck.removeFirst();
    }

    public void reshuffleDeck(int shuffleCount){
        Random rand = new Random(); // can make this as a static helper function
        int deckSize = deck.size();
        for (int j = 0; j <shuffleCount ; j++) {
            for (int i = 0; i < deckSize; i++) {
                int randInt = rand.nextInt(100000);
                int indexToSwap = randInt % deckSize;
                swap(i, indexToSwap);
            }
        }
    }

    public List<Card> getDeck(){
        return deck;
    }


    private void swap(int index1, int index2){
        Card temp1 = deck.get(index1);
        Card temp2 = deck.get(index2);
        deck.set(index1, temp2);
        deck.set(index2, temp1);
    }


}
