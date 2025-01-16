package org.example.deckofcards.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class Participant {

    private List<Card> hand = new ArrayList<>();

    public int getTotals(){
        int cardsTotal = 0;
        int aceCount = 0;
        for (Card card : hand) {
            if (card.getValue().equals(CardValue.ACE)) {
                aceCount += 1;
            }
            cardsTotal += card.getValue().getValue();
        }

        if (cardsTotal > 21 && aceCount > 0) {
            while (cardsTotal > 21 && aceCount > 0) {
                cardsTotal -= 10;
                aceCount -= 1;
            }
        }
        return cardsTotal;
    }

    public void addCard(Card card){
        hand.add(card);
    }

    public List<Card> getHand(){
        return hand;
    }
}
