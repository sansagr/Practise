package org.example.deckofcards;

import org.example.deckofcards.models.Card;
import org.example.deckofcards.models.CardValue;
import org.example.deckofcards.models.Suits;
import org.example.deckofcards.repositories.CardsRepository;
import org.example.deckofcards.services.BlackJackHandler;
import org.example.deckofcards.services.DeckHandlerService;

import java.util.ArrayList;
import java.util.List;

public class DeckOfCards {
    public static void main(String[] args) {
        int i = 0;
        List<Card> cardList = new ArrayList<>();

        for (Suits suit : Suits.values()) {
            for (CardValue cardValue : CardValue.values()) {
                Card card = new Card(i, suit, cardValue);
                cardList.add(card);
                i += 1;
            }
        }

        CardsRepository deckOfCard = new CardsRepository(cardList);

        DeckHandlerService deckHandlerService = new DeckHandlerService(deckOfCard);

        deckHandlerService.reshuffleDeck(10);
        BlackJackHandler blackJackHandler = new BlackJackHandler(deckOfCard);
        blackJackHandler.startBlackJack(4);
    }
}
