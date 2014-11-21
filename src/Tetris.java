import tetris.Board;
import utils.TetrisUtils;

/**
 * Main entry point of the game. Runs the game loop.
 * 
 * @author jimmy
 *
 */
public class Tetris {
   private static long UPDATE_INTERVAL = 1000;

   public static void main(String[] args) {
      start();
   }

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

      while (true) {
         String input = TetrisUtils.getInput();
         if (input == TetrisUtils.LEFT)
            System.out.println("LEFT was pressed");
         else if (input == TetrisUtils.UP)
            System.out.println("UP was pressed");
         else
            System.out.println(input);
      }
   }
}