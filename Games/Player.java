import java.util.Scanner;
public class Player {
  public void inputMove(String move){
    Board board = new Board();
    System.out.println("Input was " + move);
    switch(move) {
      case "A2 A3":
        char piece = board.board[7][0];
        board.board[7][0] = 'n';
        board.board[7][1] = piece;
        System.out.println(" board 6 0 is " + board.board[6][0]);
        System.out.println(" board 6 1 is " + board.board[6][1]);
        board.drawBoard();
        break;
      default:
        break;
    }
  }
}