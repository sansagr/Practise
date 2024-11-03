package org.example.snakeandladder;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Board {
    private final Cell[] board;

    public Board(int sizeOfBoard){
        this.board = new Cell[sizeOfBoard];
    }
}
