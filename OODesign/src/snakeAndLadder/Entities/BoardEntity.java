package snakeAndLadder.Entities;

public abstract class BoardEntity {
    private int start;
    private  int end;

    public BoardEntity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public abstract String getPositon();

}
