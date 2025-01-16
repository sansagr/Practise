package org.example.deckofcards.services;

import org.example.deckofcards.models.*;
import org.example.deckofcards.repositories.CardsRepository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class BlackJackHandler {

    public CardsRepository cardsRepository;
//    public Map<Integer, List<Card>> playerHands;
    public Dealer dealer = new Dealer();
    public List<Player> players = new ArrayList<>();

    public BlackJackHandler(CardsRepository cardsRepository) {
        this.cardsRepository = cardsRepository;
//        this.playerHands = new HashMap<>();
    }

    public void startBlackJack(int noOfPlayers) {

        gameInitializer(noOfPlayers);
        gameLoop(noOfPlayers);

    }
//    Starts the map and set initial states of the game
    private void gameInitializer(int noOfPlayers){
        for (int j = 0; j < noOfPlayers-1; j++) {
            players.add(new Player(j));
        }

        for (int i = 0; i < 2 * (noOfPlayers); i++) {
            int playerId = i % noOfPlayers;
            List<Card> playerCards = new ArrayList<>();
            if (playerId == noOfPlayers -1){
                playerCards = dealer.getHand();
            }
            else{
                playerCards = players.get(playerId).getHand();
            }
            Card card = cardsRepository.getTop();
            playerCards.add(card);
//            playerHands.put(playerId, playerCards);
            System.out.println("Player " + playerId + " is dealt " + card.getCardSuitAndValue() + " Totalling to " + getHandsTotal(playerCards));
        }
    }

    private void gameLoop(int noOfPlayers){
        int counter = 0;
        AtomicInteger standCount = new AtomicInteger(0);
        while (true) {
            int currentPlayer = counter % (players.size() + 1);

            // Dealer logic
            if (currentPlayer == players.size()) {
                if (processDealerTurn(standCount.get())) break;
                standCount.set(0);
            }
            // Player logic
            else {
                if (processPlayerTurn(players.get(currentPlayer), standCount)) break;
            }
            counter++;
        }
    }

    private boolean processDealerTurn(int standCount){
        List<Card> dealerCards = dealer.getHand();
        int cardsTotal = getHandsTotal(dealerCards);
        System.out.println("Dealer "  + "Total so far " + cardsTotal);
        if (cardsTotal == Constants.BLACKJACK_LIMIT) {
            System.out.println("House wins");
            return true;
        } else if (cardsTotal > Constants.BLACKJACK_LIMIT) {
            System.out.println("House looses");
            return false;
        } else if (standCount == players.size() ) {
            int winner = getHighestCountPlayer();
            System.out.println(winner + " Congrats you win!");
        } else if (cardsTotal > Constants.DEALER_STAND_THRESHOLD) {
            return false;
        } else {
            dealCardToPlayer(dealer, "Dealer");
            cardsTotal = dealer.getTotals();
            if (cardsTotal > Constants.BLACKJACK_LIMIT) {
                System.out.println("House loses");
                return false;
            } else if (cardsTotal == Constants.BLACKJACK_LIMIT) {
                System.out.println("House wins");
                return true;
            }
        }
        return false;
    }
    private boolean processPlayerTurn(Player player, AtomicInteger standCount){
        List<Card> playerCards = player.getHand();
        int playerTotal = getHandsTotal(playerCards);
        System.out.println("player " + player.getPlayerId() + " Total so far " + playerTotal);
        if (playerTotal == Constants.BLACKJACK_LIMIT) {
            System.out.println("Congrats you win!");
            return true;
        } else if (playerTotal > Constants.BLACKJACK_LIMIT) {
            System.out.println("Player " + player.getPlayerId() + " busted!");
            players.remove(player);
            return false;
        }
        String playerAction = getPlayerAction(player.getPlayerId());
        if (playerAction.equals("Hit")){
            dealCardToPlayer(player, "Player " + player.getPlayerId());
            int newTotal = getHandsTotal(playerCards);
            if (newTotal == Constants.BLACKJACK_LIMIT) {
                System.out.println("Congrats, Player " + player.getPlayerId() + " wins!");
                return true;
            } else if (newTotal > Constants.BLACKJACK_LIMIT) {
                System.out.println("Player " + player.getPlayerId() + " busted!");
                players.remove(player);
                return false;
            }
        } else if (playerAction.equals("Stand")) {
            standCount.incrementAndGet();
            if (standCount.get() ==  players.size()){
                int winner = getHighestCountPlayer();
                System.out.println(winner + " Congrats you win!");
                return true;
            }
        }
        return false;
    }

    private void dealCardToPlayer(Participant participant, String name){
        List<Card> cards = participant.getHand();
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

    private int getHighestCountPlayer() {
        int maxSum = 0;
        int playerId = -1;
        for (Player player : players) {
            int sum = 0;
            for (Card card : player.getHand()) {
                sum += card.getValue().getValue();
            }
            if (sum > maxSum) {
                maxSum = sum;
                playerId = player.getPlayerId();
            }
        }

        return playerId;
    }


}
