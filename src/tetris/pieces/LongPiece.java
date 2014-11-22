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
      if (getyPos() < Board.HEIGHT && getyPos() >= 0 && getxPos() + 2 < Board.WIDTH && getxPos() - 1 >= 0) {
         return true;
      }
      return false;
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
      // TODO Auto-generated method stub
      return false;
   }

}
