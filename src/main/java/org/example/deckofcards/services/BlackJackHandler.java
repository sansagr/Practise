package org.example.deckofcards.services;

import org.example.deckofcards.models.Card;
import org.example.deckofcards.models.CardValue;
import org.example.deckofcards.repositories.CardsRepository;

import java.util.*;

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
        int playerTurn;
        int counter = 0;
        int standCount = 0;
        while (true) {
            playerTurn = counter % noOfPlayers;
            if (playerTurn == noOfPlayers - 1) {

                List<Card> cards = playerHands.get(playerTurn);
                int cardsTotal = getHandsTotal(cards);
                System.out.println("Dealer " + playerTurn + " Total so far " + cardsTotal);

                if (cardsTotal == 21) {
                    System.out.println("House wins");
                    break;
                } else if (cardsTotal > 21) {
                    System.out.println("House looses");
                    break;

                } else if (standCount == playerHands.size() - 1) {
                    int winner = getHighestCountPlayer();
                    System.out.println(winner + " Congrats you win!");
                    break;
                } else if (cardsTotal > 16) {
                    counter += 1;
                    continue;
                } else {
                    Card card = cardsRepository.getTop();
                    System.out.println("dealer " + "is dealt " + card.getCardSuitAndValue());
                    cards.add(card);
                    cardsTotal = getHandsTotal(cards);
                    if (cardsTotal > 21) {
                        System.out.println("House loses");
                        break;
                    } else if (cardsTotal == 21) {
                        System.out.println("House wins");
                    }
                }
                standCount = 0;
            } else {
                if (!playerHands.containsKey(playerTurn)) {
                    counter += 1;
                    continue;
                }
                int playerTotal = getHandsTotal(playerHands.get(playerTurn));
                System.out.println("player " + playerTurn + " Total so far " + playerTotal);
                if (playerTotal == 21) {
                    System.out.println("Congrats you win!");
                    break;
                } else if (playerTotal > 21) {
                    System.out.println(playerTurn + " Your ass is sooo busted!!!");
                    playerHands.remove(playerTurn);
                    counter += 1;
                    continue;
                }
                Scanner scanner = new Scanner(System.in);
                System.out.println("player " + playerTurn + " Hit or Stand ");
                String input = scanner.nextLine();
                if (input.equals("Hit")) {
                    List<Card> playerCards = playerHands.get(playerTurn);
                    Card card = cardsRepository.getTop();
                    playerCards.add(card);
                    System.out.println("Player " + playerTurn + " is dealt " + card.getCardSuitAndValue() + " Totalling to " + getHandsTotal(playerCards));
                    playerHands.put(playerTurn, playerCards);
                    int playerCardTotal = getHandsTotal(playerCards);
                    if (playerCardTotal == 21) {
                        System.out.println("Congrats you win!");
                        break;
                    } else if (playerCardTotal > 21) {
                        System.out.println(playerTurn + " Your ass is sooo busted!!!");
                        playerHands.remove(playerTurn);
                        counter += 1;
                        continue;
                    }
                } else if (input.equals("Stand")) {
                    counter += 1;
                    standCount += 1;
                    continue;
                } else {
                    System.out.println("Invalid input from user, try again");
                    continue;
                }
            }
            counter += 1;

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
