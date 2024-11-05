package org.example.snakeandladder;

import java.util.*;

public class BoardGenerator {
    private int boardSize = 100;


    public Board generateBoard(HashMap<Integer, Integer> snakesAndLadders) {
        Board board = new Board(boardSize);


//      TODO: Implement the logic to initialize the board and dynamically assign the ladder and snake destination to cells
        for (int i = 0; i < boardSize; i++) {
            board.setCell(i, new Cell(i, -1));
        }

        for (Integer origin : snakesAndLadders.keySet()) {
            board.setCell(origin, new Cell(origin, snakesAndLadders.get(origin)));
        }


        return board;
    }

}
