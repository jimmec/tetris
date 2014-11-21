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
    * Implement using a rotation matrix.
    * Treating the array index of each value in matrix as a Cartesian coordiante.
    * This solution should be easier to generalize to arbitrary rotation angles.
    *
    * rotate a vector (x,y) about the origin CCW by theta degrees:
    * (x',y') = (x,y) |cos(theta) sin(theta) |
    * |-sin(theta) cos(theta)|
    *
    * Algo. iterates through each point in the array.
    * 
    * @param in
    * @param theta
    *           angle to rotate CCW in radians
    */
   public static int[][] rotate(int[][] in, double theta) {
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
            double xPrimeTranslated = xTranslated * (int) Math.cos(theta) - (int) Math.sin(theta) * yTranslated;
            double yPrimeTranslated = xTranslated * (int) Math.sin(theta) + (int) Math.cos(theta) * yTranslated;

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

   /**
    * Rotates CCW by 90 degrees
    * 
    * @param in
    * @return
    */
   public static int[][] rotate90(int[][] in) {
      return rotate(in, Math.PI / 2);
   }

   /**
    * Rotates CCW by 270 degrees ie. CW 90
    * 
    * @param in
    * @return
    */
   public static int[][] rotate270(int[][] in) {
      return rotate(in, 3 * Math.PI / 2);
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
      int[][] mat1 = new int[][] { { 0, 0, 0 }, { 1, 1, 1 }, { 0, 1, 0 } };

      int[][] mat2 = new int[][] { { 0, 0, 0 }, { 1, 1, 1 }, { 0, 0, 1 } };

      int[][] mat3 = new int[][] { { 1 } };
      int[][] mat4 = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0 } };
      int[][] mat5 = new int[][] { { 1, 1 }, { 1, 1 } };
      int[][] mat6 = new int[][] { { 0, 0, 0 }, { 1, 1, 0 }, { 0, 1, 1 } };

      prettyPrint(mat1);
      System.out.println("rotated CW by 90 is: ");
      prettyPrint(rotate90(mat1));

      prettyPrint(mat2);
      System.out.println("rotated CW by 90 is: ");
      prettyPrint(rotate90(mat2));

      // prettyPrint(mat3);
      // System.out.println("rotated CW by 90 is: ");
      // prettyPrint(rotate90(mat3));

      prettyPrint(mat4);
      System.out.println("rotated CW by 90 is: ");
      prettyPrint(rotate90(mat4));

      prettyPrint(mat6);
      System.out.println("rotated CW by 270 is: ");
      prettyPrint(rotate90(rotate90(rotate90(mat6))));
   }
}
