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

   /**
    * Given a board, check if this piece in its current position is out of bounds.
    * 
    * @param board
    * @return true if within bounds.
    */
   public abstract boolean checkBounds(Board board);

   /**
    * Given a board, check if this piece is colliding with any other piece.
    * 
    * @param board
    * @return true if no collision detected.
    */
   public abstract boolean checkCollision(Board board);

   /**
    * Given a board, checks if this piece is in a state to be anchored.
    * ie. Is there a filled board slot under directly under any part of the piece.
    * 
    * @param board
    * @return true if we should anchor this piece, false ow.
    */
   public boolean shouldAnchor(Board board) {
      boolean anchor = false;
      for (int row = 0; row < shapeMatrix.length; row++) {
         for (int col = 0; col < shapeMatrix[0].length; col++) {
            if (shapeMatrix[row][col] == 1) {
               // if the piece is here, check if its at a low boundary
               int yPos = getyPos() + row - 1;
               if (yPos + 1 >= Board.HEIGHT) {
                  return true;
               }
               // else check if theres filled board slot directly beneath
               if (board.getBoard()[yPos + 1][getxPos() + col - 1] == 1) {
                  return true;
               }
            }
         }
      }
      return false;
   }

   public boolean moveDown(Board b) {
      yPos += 1;
      boolean success = checkBounds(b) && checkCollision(b);
      if (!success) {
         yPos -= 1;
      }
      return success;
   }

   public boolean moveLeft(Board b) {
      xPos -= 1;
      boolean success = checkBounds(b) && checkCollision(b);
      if (!success) {
         xPos += 1;
      }
      return success;
   }

   public boolean moveRight(Board b) {
      xPos += 1;
      boolean success = checkBounds(b) && checkCollision(b);
      if (!success) {
         xPos -= 1;
      }
      return success;
   }

   public boolean rotate(Board b) {
      shapeMatrix = RotateMatrix.rotate90(shapeMatrix);
      boolean success = checkBounds(b) && checkCollision(b);
      if (!success) {
         shapeMatrix = RotateMatrix.rotate270(shapeMatrix);
      }
      return success;
   }

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

   public abstract int getVal(int row, int col);
}
