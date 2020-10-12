import java.util.Scanner;

public class Board {
  Main main = new Main();
  // The White peices are capital and black pieces are lowercase
  // Matrix board will contain information on the location and types of pieces, if there are no pieces it 
  // will show "n"  
  // Char[][] board is the matrix that has all of the information on what
  // pieces are where and what pieces they are
  // The char 'i' is representitive of the king piece
  public char[][] board =
    {{'r','k','b','i','q','b','k','r'},{'p','p','p','p','p','p','p','p'},
    {'n','n','n','n','n','n','n','n'},{'n','n','n','n','n','n','n','n'},
    {'n','n','n','n','n','n','n','n'},{'n','n','n','n','n','n','n','n'},
    {'P','P','P','P','P','P','P','P'},{'R','K','B','Q','I','B','K','R'}};
  public void drawBoard(){
    for(int i = 8; i > 0; i--){
      System.out.println(i + " |" + board[i - 1][0] + "|" + board[i - 1][1] + "|" + board[i - 1][2] + "|" + board[i - 1][3] + "|" + board[i - 1][4] + "|" + board[i - 1][5] + "|" + board[i - 1][6] + "|" + board[i - 1][7] + "|");
    }
    System.out.println("   A B C D E F G H");
    System.out.println();
    Scanner sc = new Scanner(System.in);
    System.out.println("Pick a piece (X-coord A-H where A = 1):");
    int moveX = sc.nextInt() - 1;
    System.out.println("Pick a piece (Y-coord 1-8):");
    int moveY = sc.nextInt() - 1;
    int[] uin = {moveX, moveY};
    System.out.println("Got user input " + moveX + ", " + moveY);
  }
}
