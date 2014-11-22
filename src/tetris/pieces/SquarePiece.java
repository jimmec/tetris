package tetris.pieces;

import tetris.Board;

public class SquarePiece extends Piece {

   public SquarePiece(int x, int y) {
      super.shapeMatrix = new int[][] { { 1, 1 }, { 1, 1 } };
      super.setxPos(x);
      super.setyPos(y);
   }

   @Override
   public boolean checkBounds(Board board) {
      if (getyPos() + 1 < Board.HEIGHT && getyPos() >= 0 && getxPos() + 1 < Board.WIDTH && getxPos() >= 0) {
         return true;
      }
      return false;
   }

   @Override
   public int getVal(int row, int col) {
      if (row <= super.getyPos() + 1 && row >= super.getyPos() && col <= super.getxPos() + 1 && col >= super.getxPos()) {
         return 1;
      } else {
         return 0;
      }
   }

   @Override
   public boolean checkCollision(Board board) {
      boolean collide = false;
      for (int row = 0; row < shapeMatrix.length; row++) {
         for (int col = 0; col < shapeMatrix[0].length; col++) {
            if (shapeMatrix[row][col] == 1) {
               // if the piece is here, make sure the board is clear there.
               boolean c = board.getBoard()[getyPos() + row][getxPos() + col] == 1;
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
               int yPos = getyPos() + row;
               if (yPos + 1 >= Board.HEIGHT) {
                  return true;
               }
               // else check if theres filled board slot directly beneath
               if (board.getBoard()[yPos + 1][getxPos() + col] == 1) {
                  return true;
               }
            }
         }
      }
      return false;
   }
}
