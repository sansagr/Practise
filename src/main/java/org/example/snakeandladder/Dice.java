package org.example.snakeandladder;

import java.util.Random;

public class Dice {
    private final Random random;
    public Dice(){
        this.random = new Random();
    }
    public int roll(){
        int diceSum = 0;
        int rollCount = 0;
        while (rollCount < 3){
            int roll = random.nextInt(6) + 1;
            diceSum += roll;
            rollCount ++;

            if (roll != 6){
                break;
            }

            if (rollCount == 3){
                return 0;
            }
        }

        return diceSum;
    }
}
