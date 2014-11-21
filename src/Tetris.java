class Tetris {
  public static void main(String[] args) {
    Board board = new Board();

    // This example code draws a horizontal bar 4 squares long.
    board.set(3, 2, 1);
    board.set(4, 2, 1);
    board.set(5, 2, 1);
    board.set(6, 2, 1);

    board.print();

    String input = TetrisUtils.getInput();
    if (input == TetrisUtils.LEFT)
      System.out.println("LEFT was pressed");
    else if (input == TetrisUtils.UP)
      System.out.println("UP was pressed");
    else
      System.out.println(input);
  }
}

class Board {
  static int WIDTH = 10;
  static int HEIGHT = 10;
  // The board is represented as an array of arrays, with 10 rows and 10 columns.
  int[][] board = new int[HEIGHT][WIDTH];

  public int[][] getBoard() { return board; }

  public void set(int x, int y, int value) { board[y][x] = value; }

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
}

