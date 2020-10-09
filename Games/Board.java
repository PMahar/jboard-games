public class Board {
  Main main = new Main();
  // Matrix board will contain information on the location and types of pieces, if there are no pieces it 
  // will show "n"  
  public void drawBoard(){
    char[][] board = {{'n','n','n','n','n','n','n','n'},{'p','p','p','p','p','p','p','p'},
  {'n','n','n','n','n','n','n','n'},{'n','n','n','n','n','n','n','n'},{'n','n','n','n','n','n','n','n'},
      {'n','n','n','n','n','n','n','n'},{'p','p','p','p','p','p','p','p'},{'R','K','B','n','n','B','K','R'}};
    for(int i = 8; i > 0; i--){
      System.out.println(i + " |" + board[i - 1][0] + "|"+ board[i - 1][1] + "|" + board[i - 1][2] + "|" + board[i - 1][3] + "|" + board[i - 1][4] + "|" + board[i - 1][5] + "|" + board[i - 1][6] + "|" + board[i - 1][7] + "|");
    }
    System.out.println("   A B C D E F G H");
  }
}