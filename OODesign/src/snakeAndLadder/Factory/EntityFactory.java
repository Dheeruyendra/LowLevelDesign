package snakeAndLadder.Factory;

import snakeAndLadder.Entities.*;

public class EntityFactory {
    public static BoardEntity createEntity(EntityENUM entity, int startCell, int endCell){
        switch (entity) {
            case SNAKE: {
                return new Snake(startCell, endCell);
            }
            case LADDER: {
                return new Ladder(startCell, endCell);
            }
            default: return null;
        }
    }
}
