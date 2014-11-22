package tetris;

import tetris.pieces.Piece;

public class Board {
   public static int WIDTH = 10;
   public static int HEIGHT = 10;
   // The board is represented as an array of arrays, with 10 rows and 10 columns.
   int[][] board = new int[HEIGHT][WIDTH];

   public int[][] getBoard() {
      return board;
   }

   public void set(int x, int y, int value) {
      board[y][x] = value;
   }

   /*
    * Prints the contents of the board and draws a border around it.
    */
   public void print() {
      for (int col = 0; col < WIDTH + 2; col++)
         System.out.print("*");
      System.out.println();

      char output;
      for (int row = 0; row < HEIGHT; row++) {
         System.out.print("|");
         for (int col = 0; col < WIDTH; col++) {
            int value = board[row][col];
            System.out.print(value == 0 ? " " : "#");
         }
         System.out.println("|");
      }

      for (int col = 0; col < WIDTH + 2; col++)
         System.out.print("*");
      System.out.println();
   }

   /**
    * Prints this board and one active piece
    * 
    * @param currPiece
    */
   public void print(Piece p) {
      for (int col = 0; col < WIDTH + 2; col++)
         System.out.print("*");
      System.out.println();

      char output;
      for (int row = 0; row < HEIGHT; row++) {
         System.out.print("|");
         for (int col = 0; col < WIDTH; col++) {
            int bValue = board[row][col];
            int piece = p.getVal(row, col);
            System.out.print(bValue == 0 && piece == 0 ? " " : "#");
         }
         System.out.println("|");
      }

      for (int col = 0; col < WIDTH + 2; col++)
         System.out.print("*");
      System.out.println();
   }

   public void anchorPiece(Piece p) {
      for (int row = 0; row < HEIGHT; row++) {
         for (int col = 0; col < WIDTH; col++) {
            board[row][col] = p.getVal(row, col) | board[row][col];
         }
      }
   }
}
