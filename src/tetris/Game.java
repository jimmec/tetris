package tetris;

import utils.TetrisUtils;

public class Game {
   /**
    * Starts the main game loop.
    */
   public static void start() {
      Board board = new Board();
      // This example code draws a horizontal bar 4 squares long.
      board.set(3, 2, 1);
      board.set(4, 2, 1);
      board.set(5, 2, 1);
      board.set(6, 2, 1);
      board.print();

      String input = TetrisUtils.getInput();
      if (input == TetrisUtils.LEFT)
         System.out.println("LEFT was pressed");
      else if (input == TetrisUtils.UP)
         System.out.println("UP was pressed");
      else
         System.out.println(input);
   }
}
