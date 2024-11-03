package org.example.snakeandladder;

import java.util.Optional;

public class Cell {
    public final int number;
    public final Optional<Integer> destination;

    public Cell(int number, Optional<Integer> destination) {
        this.number = number;
        this.destination = destination;
    }
}
