package snakeAndLadder.Entities;

import snakeAndLadder.service.DiceService;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    Queue<Player> players; Queue<Player> winners;
    int diceCount; int dimension; int size;
    Board board;

    public Game(int diceCount, int dimension) {
        this.diceCount = diceCount;
        this.dimension = dimension;
        this.size = dimension*dimension;
        this.players = new LinkedList<>();
        this.winners = new LinkedList<>();
        this.board = new Board(dimension);
    }

    public void launchGame(){
        while(players.size() > 1){
           printPlayers();
           Player currPlayer = players.poll();
           System.out.println("Current Player is " + currPlayer.getUsername() +" with a position "+ currPlayer.getPosition());
           System.out.println("Press any key  and then enter to roll dice");
            Scanner sc = new Scanner(System.in);
            char ch = sc.next().charAt(0);
           movePlayer(currPlayer, diceCount);

            if(currPlayer.getPosition() == size){
                System.out.println("Player : " + currPlayer.getUsername() + " won.");
                winners.add(currPlayer);
            }
            else{
                players.add(currPlayer);
            }
        }
    }

    private void movePlayer(Player player, int diceCount){
        int diceValue = DiceService.rollDice(diceCount);
        int finalPosition = player.getPosition() + diceValue;

        //validate final position
        if(finalPosition <= size){
            System.out.println("Moving to " + finalPosition);
            if(board.isEntityPresent(finalPosition)){
              BoardEntity currCell = board.cells.get(finalPosition);
              System.out.println(player.getUsername() + " is moving to "+ currCell.getPositon());
              finalPosition = currCell.getEnd();
            }
            //print current position
            player.setPosition(finalPosition);
        } else{
            System.out.println("OOPs, you crossed the board. Please try again later.");
        }
    }

    private void printPlayers(){
        for(Player player : players){
            System.out.println(player.getUsername() + " is at the position "+ player.getPosition());
        }
    }
    public void addPlayer(Player player){
         players.add(player);
    }
}
