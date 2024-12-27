package org.example.snakeandladder;

public class Mover {

    public void movePlayer(Player player, int stepsToMove, Board board) {
        int playerPosition = player.getPosition();
        int playerDestination = playerPosition + stepsToMove;
        if (playerDestination < 100) {
            Cell cell = board.getCell(playerDestination);
            if (cell.destination != -1) {
                playerDestination = cell.destination;
            }
            player.setPosition(playerDestination);
        }
    }
}
