package org.example.deckofcards.services;

import org.example.deckofcards.models.Card;
import org.example.deckofcards.repositories.CardsRepository;

import java.util.List;

public class DeckHandlerService {

    private final CardsRepository deckOfCards;

    public DeckHandlerService(CardsRepository deckOfCards){
        this.deckOfCards = deckOfCards;
    }

    public Card getACard(){
        return deckOfCards.getTop();
    }

    public void reshuffleDeck(int shuffleCount){
        deckOfCards.reshuffleDeck(shuffleCount);
    }

    public List<Card> fetchDeck(){
        return deckOfCards.getDeck();
    }

    public void printDeck(){
        List<Card> deck = deckOfCards.getDeck();

        int deckSize = deck.size();

        for (int i = 0; i < deckSize ; i++ ){
            System.out.println(deck.get(i).getValue() + " of " + deck.get(i).getSuit());
        }
    }

}
