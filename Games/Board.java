import java.util.Scanner;

public class Board {
  Main main = new Main();
  Player player = new Player();
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
    int pieceX = sc.nextInt() - 1; // This is the X coordinate for the piece to be moved
    System.out.println("Pick a piece (Y-coord 1-8):");
    int pieceY = sc.nextInt() - 1; // This is the Y coordinate for the piece to be moved
    int[] pin = {pieceX, pieceY}; // This is the array for combined coordinates of pieceX and pieceY
    System.out.println("Got user input " + pieceX + ", " + pieceY);
    System.out.println("Pick where to move the piece to (X-coord A-H where A = 1): ");
    int moveX = sc.nextInt() - 1; // This is the X coordinate for where to move the piece to
    System.out.println("Pick where to move the piece to (Y-coord 1-8):");
    int moveY = sc.nextInt() - 1; // This is the Y coordinate for where to move the piece to
    int[] min = {moveX, moveY}; // This is the array for the combined coordinates of moveX and moveY
    player.inputMove(pin, min); // This puts action to the players inputs
  }
}
