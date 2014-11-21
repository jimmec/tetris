package utils;

/**
 * Given a NxN array of ints, rotate the entries 90 degrees. eg.
 * 1 2
 * 3 4
 * becomes
 * 3 1
 * 4 2
 * 
 * @author jimmy
 *
 */
public class RotateMatrix {
   /**
    * Will implement using a rotation matrix.
    * Treating the array index of each value in matrix as a Cartesian coordiante.
    * This solution should be easier to generalize to arbitrary rotation angles.
    *
    * rotate a vector (x,y) about the origin CCW by theta degrees:
    * (x',y') = (x,y) |cos(theta) sin(theta) |
    * |-sin(theta) cos(theta)|
    *
    * Algo. iterates
    */
   public static int[][] rotate90(int[][] in) {
      // Shotty input validation...
      if (in[0].length != in.length) {
         throw new IllegalArgumentException("input is not a square matrix!");
      }

      int n = in.length;

      // find origin of matrix, so we can rotate about the center of matrix
      double xOffset;
      double yOffset;
      if (n % 2 != 0) {
         xOffset = (n / 2); // need integer rounding here
         yOffset = (n / 2);
      } else {
         xOffset = (n / 2) - 0.5; // need to center in even case
         yOffset = (n / 2) - 0.5;
      }

      int[][] result = new int[n][n];

      for (int y = 0; y < n; y++) {
         for (int x = 0; x < n; x++) {
            // Translate coordinates so we are rotating about the center of matrix
            double xTranslated = x - xOffset;
            double yTranslated = y - yOffset;

            // Need to negate the y coordinate, since array indexing means higher in matrix => smaller index
            yTranslated = -yTranslated;
            /*
             * Apply rotation operator.
             * To rotate CW 90 deg = rotate CCW 270 deg, our rotation matrix is:
             * A = |0 -1|
             * |1 0|
             * (xPrimeTranslated, yPrimeTranslated) = (xTranslated, yTranslated) * A
             */
            double xPrimeTranslated = xTranslated * 0 + 1 * yTranslated;
            double yPrimeTranslated = -xTranslated + 0 * yTranslated;

            // Flip y coordinate back
            yPrimeTranslated = -yPrimeTranslated;

            // Translate coordinates back to indices in new position
            int xPrime = new Double(xPrimeTranslated + xOffset).intValue();
            int yPrime = new Double(yPrimeTranslated + yOffset).intValue();

            result[yPrime][xPrime] = in[y][x];
         }
      }

      return result;
   }

   public static void prettyPrint(int[][] in) {
      for (int y = 0; y < in.length; y++) {
         System.out.print("| ");
         for (int x = 0; x < in[y].length; x++) {
            System.out.print(in[y][x] + " ");
         }
         System.out.println("|");
      }
   }

   public static void main(String[] args) {
      int[][] mat1 = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

      int[][] mat2 = new int[][] { { 1, 2, 3, 1 }, { 4, 5, 6, 2 }, { 7, 8, 9, 3 }, { 8, 8, 8, 8 } };

      int[][] mat3 = new int[][] { { 1 } };

      prettyPrint(mat1);
      System.out.println("rotated CW by 90 is: ");
      prettyPrint(rotate90(mat1));

      prettyPrint(mat2);
      System.out.println("rotated CW by 90 is: ");
      prettyPrint(rotate90(mat2));

      prettyPrint(mat3);
      System.out.println("rotated CW by 90 is: ");
      prettyPrint(rotate90(mat3));
   }
}
