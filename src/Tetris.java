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
    * Controls the game logic.
    */
   public static void start() {
      boolean again = true;
      do {
         Game g = new Game();
         boolean shouldAnchor = false;
         boolean gameOver = false;

         while (!gameOver) {
            g.render();

            String input = TetrisUtils.getInput();
            if (input == TetrisUtils.LEFT)
               g.moveLeft();
            else if (input == TetrisUtils.UP)
               g.rotate();
            else if (input == TetrisUtils.RIGHT)
               g.moveRight();
            else
               g.moveDown();

            if (shouldAnchor) {
               g.anchorPiece();
               if (!g.genNextPiece()) {
                  gameOver = true;
               }
               shouldAnchor = false;
            } else {
               // check if we should be anchoring next turn
               shouldAnchor = g.shouldAnchor();
            }
         }

         System.out.println("Game OVER! Press UP to play again... anything else to quit.");
         String input = TetrisUtils.getInput();
         if (!(input == TetrisUtils.UP)) {
            again = false;
         }
      } while (again);
   }
}