package snakeAndLadder.Entities;

import snakeAndLadder.Factory.EntityENUM;
import snakeAndLadder.Factory.EntityFactory;
import snakeAndLadder.service.RandomNumberService;

import java.util.HashMap;

public class Board {
      int size;
      HashMap<Integer, BoardEntity> cells;

      Board(int n){
            //initialize size and cells
            this.size = n*n;     //dimension of board
            cells = new HashMap<>();

            // fill 'n' random snakes and ladders
            for(int i=0; i<n; i++) {
                  addSnake();
                  addLadder();
            }
      }

      private void addSnake(){
            //start cell of snake
            int startRange = 2;
            int endRange = size-1;
            int randomStartCell = getRandomCell(startRange, endRange);

            //end cell of snake
            endRange = randomStartCell-1;
            int randomEndCell = getRandomCell(startRange, endRange);

            //add snake start cell to the board
            if(!isEntityPresent(randomStartCell)) {
                  //addEntityToBoard(randomStartCell, new Snake(randomStartCell, randomEndCell));
                  addEntityToBoard(randomStartCell, EntityFactory.createEntity(EntityENUM.SNAKE, randomStartCell, randomEndCell));
            }
      }
      private void addLadder(){
            //start cell of ladder
            int startRange = 2;
            int endRange = size-1;
            int randomStartCell = getRandomCell(startRange, endRange);

            //end of ladder
            startRange = randomStartCell+1;
            int randomEndCell = getRandomCell(startRange, endRange);

            //add ladder to the board
            if(!isEntityPresent(randomStartCell)){
                  addEntityToBoard(randomStartCell, EntityFactory.createEntity(EntityENUM.SNAKE, randomStartCell, randomEndCell));
            }
      }
      private int getRandomCell(int startRange,  int endRange){
            return RandomNumberService.getNumber(startRange, endRange);
      }
      Boolean isEntityPresent(int cellIndex){
            if(cells.containsKey(cellIndex))return true;
            return false;
      }
      private void addEntityToBoard(int cellIndex, BoardEntity entity){
            cells.put(cellIndex, entity);
      }

}
