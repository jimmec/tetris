package tetris.pieces;

import tetris.Board;

public class AnglePiece extends Piece {
   public AnglePiece(int x, int y) {
      super.shapeMatrix = new int[][] { { 0, 0, 0 }, { 1, 1, 1 }, { 0, 0, 1 } };
      super.setxPos(x - 1);
      super.setyPos(y);
   }

   @Override
   public boolean checkBounds(Board board) {
      boolean outBounds = false;
      for (int row = 0; row < shapeMatrix.length; row++) {
         for (int col = 0; col < shapeMatrix[0].length; col++) {
            if (shapeMatrix[row][col] == 1) {
               outBounds = getxPos() + col - 1 < 0 || getxPos() + col - 1 > Board.WIDTH - 1 || getyPos() + row - 1 < 0
                     || getyPos() + row - 1 > Board.HEIGHT - 1;
            }
         }
      }
      return outBounds;
   }

   @Override
   public int getVal(int row, int col) {
      // if (row,col) is in the 3x3 shape matrix
      if (row <= super.getyPos() + 1 && row >= super.getyPos() - 1 && col <= super.getxPos() + 1
            && col >= super.getxPos() - 1) {
         return shapeMatrix[row - super.getyPos() + 1][col - super.getxPos() + 1];
      }
      return 0;
   }

   @Override
   public boolean checkCollision(Board board) {
      // TODO Auto-generated method stub
      return false;
   }

}
