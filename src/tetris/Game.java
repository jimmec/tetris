package tetris;

import tetris.pieces.AnglePiece;
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
      currPiece = new AnglePiece(3, 0);
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

   public boolean rotate() {
      return currPiece.rotate(board);
   }

   public void render() {
      board.print(currPiece);
   }

}
