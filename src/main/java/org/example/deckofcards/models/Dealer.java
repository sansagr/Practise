package org.example.deckofcards.models;

import java.util.List;

public class Dealer extends Participant{

        public boolean shouldStand(){
            return getTotals() > Constants.DEALER_STAND_THRESHOLD;
        }

}
