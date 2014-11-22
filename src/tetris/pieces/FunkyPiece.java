package tetris.pieces;

import tetris.Board;

public class FunkyPiece extends Piece {
   public FunkyPiece(int x, int y) {
      super.shapeMatrix = new int[][] { { 0, 0, 0 }, { 1, 1, 0 }, { 0, 1, 1 } };
      super.setxPos(x - 1);
      super.setyPos(y);
   }

   @Override
   public boolean checkBounds(Board board) {
      if (getyPos() + 1 < Board.HEIGHT && getyPos() >= 0 && getxPos() + 1 < Board.WIDTH && getxPos() - 1 >= 0) {
         return true;
      }
      return false;
   }

   @Override
   public int getVal(int row, int col) {
      // if (row,col) is in the 3x3 shape matrix
      if (row <= super.getyPos() + 1 && row >= super.getyPos() - 1 && col <= super.getxPos() + 1
            && col >= super.getxPos() - 1) {
         return super.shapeMatrix[row - super.getyPos() + 1][col - super.getxPos() + 1];
      }
      return 0;
   }

   @Override
   public boolean checkCollision(Board board) {
      // TODO Auto-generated method stub
      return false;
   }

}
