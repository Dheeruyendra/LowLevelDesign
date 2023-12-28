package snakeAndLadder;

import snakeAndLadder.Entities.Game;
import snakeAndLadder.Entities.Player;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        int diceCount = 1;
        int dimension = 10;
        Game currGame = new Game(diceCount, dimension);

        Player player1 = new Player("Divyansh");
        Player player2 = new Player("Geet");
        Player player3 = new Player("Aman");

        currGame.addPlayer(player1);
        currGame.addPlayer(player2);
        currGame.addPlayer(player3);

        currGame.launchGame();
    }
}
