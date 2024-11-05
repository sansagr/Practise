package org.example.snakeandladder;

import java.util.List;

public class SnakeAndLadder {

    public Player startGame(List<Player> players, Board board, Dice dice, Mover mover) {
//  TODO: Takes the list of players, Board, Dice, Mover and starts the game and manages which player will take turn

        int numberOfPlayers = players.size();
        int currentPlayerIndex = 0;
        Player winner = null;

        while (players.get(currentPlayerIndex).getPosition() < 99) {
            int stepsToMove = dice.roll();
            Player currentPlayer = players.get(currentPlayerIndex);
            int playerPreviousPosition = currentPlayer.getPosition();
            System.out.println("Player: " + currentPlayer.getColour() + " rolled: " + stepsToMove);

//          Updates the player's position
            mover.movePlayer(currentPlayer, stepsToMove, board);

            System.out.println("Player: " + currentPlayer.getColour() + " moved from position: " + playerPreviousPosition + " to position: " + currentPlayer.getPosition());
            if (currentPlayer.getPosition() == 99) {
                winner = currentPlayer;
                break;
            }
            currentPlayerIndex = (currentPlayerIndex + 1) % numberOfPlayers;
        }
        return winner;
    }
}
