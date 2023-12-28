package snakeAndLadder.service;

public class RandomNumberService {
    public static int getNumber(int startRange, int endRange){
        return (int) Math.floor(Math.random()*(endRange - startRange +1)) + startRange;
    }
}
