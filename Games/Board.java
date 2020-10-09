
public class Board {
  Main main = new Main();
  // Matrix board will contain information on the location and types of pieces, if there are no pieces it 
  // will show "n"
  String[][] board = {"n","n","n","n","n","n","n","n"}, {"n","n","n","n","n","n","n","n"}, 
  {"n","n","n","n","n","n","n","n"}, {"n","n","n","n","n","n","n","n"}, {"n","n","n","n","n","n","n","n"},
  {"n","n","n","n","n","n","n","n"}, {"n","n","n","n","n","n","n","n"}, {"n","n","n","n","n","n","n","n"};
  public void drawBoard(){
    for( int i = 8; i > 0; i--){
      System.out.println(i + " |" + board[i - ][0] + "|"+ board[i - 1][1] + "|" + board[i - 1][2] + "|" + board[i - 1][3] + "|" + board[i - 1][4] + "|" + board[i - 1][5] + "|" + board[i - 1][6] + "|" + board[i - 1][7] + "|");
    }
    System.out.println("   A B C D E F G H");
  }
}