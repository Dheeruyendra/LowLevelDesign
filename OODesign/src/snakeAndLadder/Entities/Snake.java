package snakeAndLadder.Entities;

public class Snake extends BoardEntity {

    public Snake(int start, int end){
        super(start, end);
    }
    @Override
    public String getPositon() {
        return "S: "+ getEnd();
    }
}
