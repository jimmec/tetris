package tetris.pieces;

import tetris.Board;

public class SquarePiece extends Piece {

   public SquarePiece() {
      super.shapeMatrix = new int[][] { { 1, 1 }, { 1, 1 } };
   }

   @Override
   public boolean checkBounds(Board board) {
      return true;
   }

}
