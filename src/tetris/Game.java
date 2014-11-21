package tetris;

import tetris.pieces.Piece;

/**
 * Manages the Board and pieces.
 * 
 * @author jimmy
 *
 */
public class Game {
   private Board board;
   private Piece currPiece;

   public Game() {
      board = new Board();
   }

   public boolean moveLeft() {
      return currPiece.moveLeft(board);
   }

   public boolean moveRight() {
      return currPiece.moveRight(board);
   }

   public boolean moveDown() {
      return currPiece.moveDown(board);
   }

   public void render() {
      board.print(currPiece);

   }

}
