package tetris;

import java.util.Random;

import tetris.pieces.AnglePiece;
import tetris.pieces.FunkyPiece;
import tetris.pieces.LongPiece;
import tetris.pieces.Piece;
import tetris.pieces.SquarePiece;
import tetris.pieces.TriPiece;

/**
 * Manages the Board and pieces.
 * 
 * @author jimmy
 *
 */
public class Game {
   private static Random rand = new Random();
   private static int START_X = 3;
   private static int START_Y = 0;
   private Board board;
   private Piece currPiece;

   public Game() {
      board = new Board();
      genNextPiece();
   }

   public synchronized boolean moveLeft() {
      return currPiece.moveLeft(board);
   }

   public synchronized boolean moveRight() {
      return currPiece.moveRight(board);
   }

   public synchronized boolean moveDown() {
      return currPiece.moveDown(board);
   }

   public synchronized boolean rotate() {
      return currPiece.rotate(board);
   }

   public synchronized void render() {
      board.print(currPiece);
   }

   public synchronized boolean checkCollision() {
      return currPiece.checkCollision(board);
   }

   /**
    * Randomly generate the next piece, starting at (START_X, START_Y)
    * 
    * @return true if new piece placed without collision. False o.w.
    */
   public synchronized boolean genNextPiece() {
      int piece = rand.nextInt(5);
      switch (piece) {
      case 0:
         currPiece = new AnglePiece(START_X, START_Y);
         return checkCollision();
      case 1:
         currPiece = new FunkyPiece(START_X, START_Y);
         return checkCollision();
      case 2:
         currPiece = new LongPiece(START_X, START_Y);
         return checkCollision();
      case 3:
         currPiece = new SquarePiece(START_X, START_Y);
         return checkCollision();
      default:
         currPiece = new TriPiece(START_X, START_Y);
         return checkCollision();
      }
   }

   public synchronized boolean shouldAnchor() {
      return currPiece.shouldAnchor(board);
   }

   public synchronized void anchorPiece() {
      board.anchorPiece(currPiece);
   }
}
