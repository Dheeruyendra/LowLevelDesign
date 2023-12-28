package snakeAndLadder.service;

public class DiceService {
    public static int rollDice(int diceCount){
          int minValue = 1;
          int maxValue = 6*diceCount;
          return RandomNumberService.getNumber(minValue, maxValue);
    }
}
