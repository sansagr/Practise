package org.example.snakeandladder;

import java.util.*;

public class SnakeAndLadderGenerator {

//  The method takes in count of ladder and snakes and pops out a map
//  that contains the origin to destination mapping to be used by board generator

    //  TODO: The current method to generate snakes and ladders is inefficient it can be improved
    public HashMap<Integer, Integer> generateSnakesAndLadders(int numberOfLadder, int numberOfSnakes) {

        List<Integer> originsAndDestination = new ArrayList<>();
        List<List<Integer>> uniqueLadderDestinations = new ArrayList<>();
        List<List<Integer>> uniqueSnakeDestinations = new ArrayList<>();
        HashMap<Integer, Integer> snakesAndLadders = new HashMap<>();

        Random random = new Random();

        while (uniqueLadderDestinations.size() < numberOfLadder) {
            int destination = random.nextInt(60) + 30;
            int origin = random.nextInt(destination - 10) + 10;
            if (!originsAndDestination.contains(destination) && !originsAndDestination.contains(origin) && destination > origin) {
                originsAndDestination.add(destination);
                originsAndDestination.add(origin);
                uniqueLadderDestinations.add(List.of(origin, destination));
                snakesAndLadders.put(origin, destination);
            }
        }
        while (uniqueSnakeDestinations.size() < numberOfSnakes) {
            int destination = random.nextInt(57) + 1;
            int origin = random.nextInt(98 - destination) + destination;
            if (!originsAndDestination.contains(destination) && !originsAndDestination.contains(origin) && destination < origin) {
                originsAndDestination.add(destination);
                originsAndDestination.add(origin);
                uniqueSnakeDestinations.add(List.of(origin, destination));
                snakesAndLadders.put(origin, destination);
            }
        }

        return snakesAndLadders;
    }
}
