package tetris.pieces;

import tetris.Board;

public class LongPiece extends Piece {
   public LongPiece(int x, int y) {
      super.shapeMatrix = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0 } };
      super.setxPos(x - 2);
      super.setyPos(y);
   }

   @Override
   public boolean checkBounds(Board board) {
      boolean outBounds = false;
      for (int row = 0; row < shapeMatrix.length; row++) {
         for (int col = 0; col < shapeMatrix[0].length; col++) {
            if (shapeMatrix[row][col] == 1) {
               outBounds = outBounds || getxPos() + col - 2 < 0 || getxPos() + col - 2 > Board.WIDTH - 1
                     || getyPos() + row - 2 < 0 || getyPos() + row - 2 > Board.HEIGHT - 1;
            }
         }
      }
      return !outBounds;
   }

   @Override
   public int getVal(int row, int col) {
      // if (row,col) is in the 5x5 shape matrix
      if (row <= super.getyPos() + 2 && row >= super.getyPos() - 2 && col <= super.getxPos() + 2
            && col >= super.getxPos() - 2) {
         return super.shapeMatrix[row - super.getyPos() + 2][col - super.getxPos() + 2];
      }
      return 0;
   }

   @Override
   public boolean checkCollision(Board board) {
      boolean collide = false;
      for (int row = 0; row < shapeMatrix.length; row++) {
         for (int col = 0; col < shapeMatrix[0].length; col++) {
            if (shapeMatrix[row][col] == 1) {
               // if the piece is here, make sure the board is clear there.
               boolean c = board.getBoard()[getyPos() + row - 2][getxPos() + col - 2] == 1;
               // if (c) {
               // System.out.println(collide);
               // System.out.println(String.format("At: (%d,%d)", row, col));
               // System.out.println(String.format("Board: (%d,%d)", getyPos(), getxPos()));
               // }
               collide = collide || c;
            }
         }
      }
      return !collide;
   }

   /**
    * Given a board, checks if this piece is in a state to be anchored.
    * ie. Is there a filled board slot under directly under any part of the piece.
    * 
    * @param board
    * @return true if we should anchor this piece, false ow.
    */
   @Override
   public boolean shouldAnchor(Board board) {
      boolean anchor = false;
      for (int row = 0; row < shapeMatrix.length; row++) {
         for (int col = 0; col < shapeMatrix[0].length; col++) {
            if (shapeMatrix[row][col] == 1) {
               // if the piece is here, check if its at a low boundary
               int yPos = getyPos() + row - 2;
               if (yPos + 1 >= Board.HEIGHT) {
                  return true;
               }
               // else check if theres filled board slot directly beneath
               if (board.getBoard()[yPos + 1][getxPos() + col - 2] == 1) {
                  return true;
               }
            }
         }
      }
      return false;
   }
}
