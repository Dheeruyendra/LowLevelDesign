package snakeAndLadder.Entities;

public class Ladder extends BoardEntity {


    public Ladder(int start, int end) {
        super(start, end);
    }
    @Override
    public String getPositon() {
        return "E: " + getStart();
    }
}
