package org.example.snakeandladder;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Board {
    private final Cell[] board;

    public Board(int sizeOfBoard){
        this.board = new Cell[sizeOfBoard];
    }

    public Cell[] getCells(){
        return board;
    }

    public Cell getCell(int index){
        return board[index];
    }

    public void setCell(int index, Cell cell){
        board[index] = cell;
    }
}
