import tetris.Game;
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
      Game g = new Game();

      while (true) {
         g.render();
         String input = TetrisUtils.getInput();
         if (input == TetrisUtils.LEFT)
            g.moveLeft();
         else if (input == TetrisUtils.UP)
            System.out.println("UP was pressed");
         else if (input == TetrisUtils.RIGHT)
            g.moveRight();
         else
            g.moveDown();
      }
   }
}