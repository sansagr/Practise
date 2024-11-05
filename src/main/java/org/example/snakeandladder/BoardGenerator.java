package org.example.snakeandladder;

import java.util.*;

public class BoardGenerator {


    public Board generateBoard(HashMap<Integer, Integer> snakesAndLadders) {
        int boardSize = 100;
        Board board = new Board(boardSize);


        for (int i = 0; i < boardSize; i++) {
            board.setCell(i, new Cell(i, -1));
        }

        for (Integer origin : snakesAndLadders.keySet()) {
            board.setCell(origin, new Cell(origin, snakesAndLadders.get(origin)));
        }


        return board;
    }

}
