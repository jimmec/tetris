import tetris.Game;
import utils.TetrisUtils;

/**
 * Main entry point of the game. Runs the game loop.
 * 
 * @author jimmy
 *
 */
public class Tetris {
   private static long UPDATE_INTERVAL = 2000;

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
         final Game g = new Game();
         Thread mainGame = new Thread(new Runnable() {
            @Override
            public void run() {
               boolean gameOver = false;

               while (!gameOver) {
                  g.render();
                  g.moveDown();

                  if (g.shouldAnchor()) {
                     g.anchorPiece();
                     if (!g.genNextPiece()) {
                        gameOver = true;
                     }
                  }
                  try {
                     Thread.sleep(UPDATE_INTERVAL);
                  } catch (InterruptedException e) {
                     // stop this background auto falling when interrupted by main thread.
                     return;
                  }
               }
               // if an auto fall resulted in game over, end execution too.
               return;
            }
         });
         mainGame.start();

         // Use this original thread to make moves.
         boolean gameOver = false;

         while (!gameOver) {
            if (g.shouldAnchor()) {
               g.anchorPiece();
               if (!g.genNextPiece()) {
                  gameOver = true;
               }
            }
            String input = TetrisUtils.getInput();
            if (input == TetrisUtils.LEFT)
               g.moveLeft();
            else if (input == TetrisUtils.UP)
               g.rotate();
            else if (input == TetrisUtils.RIGHT)
               g.moveRight();
            else
               g.moveDown();

            g.render();
         }
         mainGame.interrupt();
         System.out.println("Game OVER! Press UP to play again... anything else to quit.");
         String input = TetrisUtils.getInput();
         if (!(input == TetrisUtils.UP)) {
            again = false;
         }

      } while (again);
   }
}