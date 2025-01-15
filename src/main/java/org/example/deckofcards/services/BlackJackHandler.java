package org.example.deckofcards.services;

import org.example.deckofcards.models.Card;
import org.example.deckofcards.models.CardValue;
import org.example.deckofcards.repositories.CardsRepository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class BlackJackHandler {

    public CardsRepository cardsRepository;
    public Map<Integer, List<Card>> playerHands;

    public BlackJackHandler(CardsRepository cardsRepository) {
        this.cardsRepository = cardsRepository;
        this.playerHands = new HashMap<>();
    }

    public void startBlackJack(int noOfPlayers) {

        gameInitializer(noOfPlayers);
        gameLoop(noOfPlayers);

    }
//    Starts the map and set initial states of the game
    private void gameInitializer(int noOfPlayers){
        for (int j = 0; j < noOfPlayers; j++) {
            playerHands.putIfAbsent(j, new ArrayList<>());
        }

        for (int i = 0; i < 2 * noOfPlayers; i++) {
            int playerId = i % noOfPlayers;
            List<Card> playerCards = playerHands.get(playerId);
            Card card = cardsRepository.getTop();
            playerCards.add(card);
            playerHands.put(playerId, playerCards);
            System.out.println("Player " + playerId + " is dealt " + card.getCardSuitAndValue() + " Totalling to " + getHandsTotal(playerCards));
        }
    }

    private void gameLoop(int noOfPlayers){
        int counter = 0;
        AtomicInteger standCount = new AtomicInteger(0);
        while (true) {
            int currentPlayer = counter % noOfPlayers;

            // Dealer logic
            if (currentPlayer == noOfPlayers - 1) {
                if (processDealerTurn(currentPlayer, standCount.get())) break;
                standCount.set(0);
            }
            // Player logic
            else {
                if (processPlayerTurn(currentPlayer, standCount)) break;
            }
            counter++;
        }
    }

    private boolean processDealerTurn(int playerTurn, int standCount){
        List<Card> dealerCards = playerHands.get(playerTurn);
        int cardsTotal = getHandsTotal(dealerCards);
        System.out.println("Dealer " + playerTurn + " Total so far " + cardsTotal);
        if (cardsTotal == 21) {
            System.out.println("House wins");
            return true;
        } else if (cardsTotal > 21) {
            System.out.println("House looses");
            return false;
        } else if (standCount == playerHands.size() - 1) {
            int winner = getHighestCountPlayer();
            System.out.println(winner + " Congrats you win!");
        } else if (cardsTotal > 16) {
            return false;
        } else {
            dealCardToPlayer(playerTurn, "Dealer");
            cardsTotal = getHandsTotal(dealerCards);
            if (cardsTotal > 21) {
                System.out.println("House loses");
                return false;
            } else if (cardsTotal == 21) {
                System.out.println("House wins");
                return true;
            }
        }
        return false;
    }
    private boolean processPlayerTurn(int playerTurn, AtomicInteger standCount){
        if (!playerHands.containsKey(playerTurn)) {
            return false;
        }
        List<Card> playerCards = playerHands.get(playerTurn);
        int playerTotal = getHandsTotal(playerHands.get(playerTurn));
        System.out.println("player " + playerTurn + " Total so far " + playerTotal);
        if (playerTotal == 21) {
            System.out.println("Congrats you win!");
            return true;
        } else if (playerTotal > 21) {
            System.out.println("Player " + playerTurn + " busted!");
            playerHands.remove(playerTurn);
            return false;
        }
        String playerAction = getPlayerAction(playerTurn);
        if (playerAction.equals("Hit")){
            dealCardToPlayer(playerTurn, "Player " + playerTurn);
            int newTotal = getHandsTotal(playerCards);
            if (newTotal == 21) {
                System.out.println("Congrats, Player " + playerTurn + " wins!");
                return true;
            } else if (newTotal > 21) {
                System.out.println("Player " + playerTurn + " busted!");
                playerHands.remove(playerTurn);
                return false;
            }
        } else if (playerAction.equals("Stand")) {
            standCount.incrementAndGet();
            if (standCount.get() ==  playerHands.size() - 1){
                int winner = getHighestCountPlayer();
                System.out.println(winner + " Congrats you win!");
                return true;
            }
        }
        return false;
    }

    private void dealCardToPlayer(int playerTurn, String name){
        List<Card> cards = playerHands.get(playerTurn);
        Card card = cardsRepository.getTop();
        cards.add(card);
        System.out.println(name + " is dealt " + card.getCardSuitAndValue() +
                " Totalling to " + getHandsTotal(cards));
    }

    private String getPlayerAction(int playerTurn){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("player " + playerTurn + " Hit or Stand ");
            String input = scanner.nextLine();
            if (input.equals("Hit") || input.equals("Stand")){
                return input;
            }
            System.out.println("Invalid input, try again");

        }
    }

    private int getHandsTotal(List<Card> cards) {
        int cardsTotal = 0;
        int aceCount = 0;
        for (Card card : cards) {
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

    private String checkHandStatus(int playerId) {
        List<Card> cards = playerHands.get(playerId);
        int getTotals = getHandsTotal(cards);
        if (getTotals > 21) {
            return "Busted";
        } else if (getTotals == 21) {
            return "Winner";
        } else {
            return "notBusted";
        }
    }

    private int getHighestCountPlayer() {
        int maxSum = 0;
        int playerId = -1;
        for (int player : playerHands.keySet()) {
            int sum = 0;
            for (Card card : playerHands.get(player)) {
                sum += card.getValue().getValue();
            }
            if (sum > maxSum) {
                maxSum = sum;
                playerId = player;
            }
        }

        return playerId;
    }


}
