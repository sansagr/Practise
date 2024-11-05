package org.example.snakeandladder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SnakeAndladderDemo {
    //    TODO: implement the game loop here
    public static void main(String[] args) {

        SnakeAndLadderGenerator snakeAndLadderGenerator = new SnakeAndLadderGenerator();
        HashMap<Integer, Integer> snakesAndLadders = snakeAndLadderGenerator.generateSnakesAndLadders(5, 5);

        BoardGenerator boardGenerator = new BoardGenerator();
        Board board = boardGenerator.generateBoard(snakesAndLadders);

        Player player1 = new Player(1, "red", 0);
        Player player2 = new Player(2, "green", 0);
        List<Player> players = new ArrayList<>(List.of(player1, player2));

        Mover mover = new Mover();

        Dice dice = new Dice();

        SnakeAndLadder snakeAndLadder = new SnakeAndLadder();
        Player winner = snakeAndLadder.startGame(players, board, dice, mover);
        System.out.println("Player: " + winner.getColour() + " is the winner ");

    }


}
