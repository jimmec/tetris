package tetris.pieces;

import tetris.Board;
import utils.RotateMatrix;

/**
 * Represents a tetris piece.
 * 
 * @author jimmy
 *
 */
public abstract class Piece {
   /* The x position of the center of the piece */
   private int xPos;
   /* The y position of the center of the piece */
   private int yPos;
   protected int[][] shapeMatrix;

   public boolean moveDown(Board b) {
      yPos += 1;
      boolean success = checkBounds(b);
      if (!success) {
         yPos += 1;
      }
      return success;
   }

   public boolean moveLeft(Board b) {
      xPos -= 1;
      boolean success = checkBounds(b);
      if (!success) {
         xPos += 1;
      }
      return success;
   }

   public boolean moveRight(Board b) {
      xPos += 1;
      boolean success = checkBounds(b);
      if (!success) {
         xPos -= 1;
      }
      return success;
   }

   public boolean rotate(Board b) {
      shapeMatrix = RotateMatrix.rotate90(shapeMatrix);
      boolean success = checkBounds(b);
      if (!success) {
         shapeMatrix = RotateMatrix.rotate270(shapeMatrix);
      }
      return success;
   }

   /**
    * Given a board, check if this piece in its current position is out of bounds or colliding.
    * 
    * @param board
    */
   public abstract boolean checkBounds(Board board);

   public int getyPos() {
      return yPos;
   }

   public void setyPos(int yPos) {
      this.yPos = yPos;
   }

   public int getxPos() {
      return xPos;
   }

   public void setxPos(int xPos) {
      this.xPos = xPos;
   }

   public int[][] getShapeMatrix() {
      return shapeMatrix;
   }
}
