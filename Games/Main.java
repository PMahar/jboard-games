import java.util.ArrayList;
import java.util.Arrays;
/**
 * This is the main class for executing methods in this project
 * 
 * */
public class Main {
  
  /*
   * This is the concept of chess.
   * Pawns can move 1 space forward, can only move 1 space diagonally in front 
   * of itself in an offensive. For it's first move it can move either one or 
   * two spaces forward. There are eight pawns per player in a game of chess,
   * unless a handicap is given.
   * 
   * The queen can move in a straight line in any direction, along with attack
   * in a straight line in any direction. There is one queen per player, and it
   * is placed next to the king on the oposing players color.
   * 
   * The piece called "bishop" can move in a sraight line in a diagonal direction.
   * At the beginning of the game there are 2 bishops per player. Each bishop must
   * move on a different color. 
   * 
   * The rook can move in four directions, forward, backward, to the left, and 
   * to the right. It can move any amount of spaces. At the beginning of a game 
   * there shall be 2 rooks, unless a handicap is instituted.
   * 
   * The knight is often represented by a piece sculpted with the head of a horse,
   * it must move three spaces in a straight line, and the move one space in a 
   * direction perpendicular to the first three spaces, this is the only piece that
   * can "jump over pieces". It is a normal practice to start a game of chess with 
   * 2 knights.
   * 
   * The king can move in a straight line in any direction, but it can only move
   * one space at a time. If the king is in a posistion where it can be attacked/
   * taken, it is customary for the person who can attack to call "check". Once 
   * a player is in "check" it is required that the player move a piece in order 
   * to protect the king, if nothing can be done to protect the opposing player 
   * will call "checkmate" instead of "check" and that is the end of the game.
   * There is one scenario in which a king can move 2 spaces, this is called 
   * "castle". It happens when the king and the rook "swap places".
   * */
  //Because System.out.print() can't be called from outside a method and we can't
  //establish a public variable in a static method, we'll take user input in class
  //Board
  public static void main(String[] args) {
    Board board = new Board();
    Player player = new Player();
    System.out.println("Uppercase letters are white, lowercase are black");
    board.drawBoard(); // Create the board
  }
} 
