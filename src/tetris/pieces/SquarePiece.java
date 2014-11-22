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
      // TODO Auto-generated method stub
      return false;
   }
}
