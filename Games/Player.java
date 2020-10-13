import java.util.Scanner;
public class Player {
  
  // These are to make moving pieces a little bit easier
  private int a = 0;
  private int b = 1;
  private int c = 2;
  private int d = 3;
  private int e = 4;
  private int f = 5;
  private int g = 6;
  private int h = 7;
  
  /**
   * 
   * @param piece is the first array given and is the coordinates for the piece to be moved
   * @param moveTo is the second array given and will be checked to see if there is a pre-existing piece
   * */
  public void inputMove(int[] piece, int[] move){
    Board board = new Board();
    // If the location to move to doesn't have any piece there then move onto the next step of moving a piece
    if(board.board[move[1]][move[0]] == 'n'){
      // Sets a char variable "pieceNam" to the value of the piece to be moved
      char pieceNam = board.board[piece[1]][piece[0]];
      switch(pieceNam){
        case 'k':
          System.out.println("Piece chosen is a knight");
          // If the difference between the x coordinates of the piece and where to move are within the rules of 
          // movement for a knight
          if((piece[1] - move[1]) == 3 || (piece[1] - move[1]) == -3 || (piece[1] - move[1]) == 1 || (piece[1] - move[1]) == -1){
            System.out.println("x is working");
            // If the difference between the x coordinates of the piece and where to move are within the rules
            // of movement for a knight
            if((piece[0] - move[0]) == 3 || (piece[0] - move[0]) == -3 || (piece[0] - move[0]) == 1 || (piece[0] - move[0]) == -1){
              System.out.println("Y is working");
              // Sets the original location of the piece to 'n' (null/ nothing)
              board.board[piece[1]][piece[0]] = 'n'; 
              System.out.println(board.board[piece[1]][piece[0]]);
              // Sets the location to move to, to the piece type
              board.board[move[1]][move[0]] = pieceNam; 
              // Draws the board
              board.drawBoard();
            }
          }
          break;
       case 'K':
          System.out.println("The piece chosen is a white knight");
          // If the difference between the x coordinates of the piece and where to move are within the rules of 
          // movement for a knight
          if((piece[1] - move[1]) == 3 || (piece[1] - move[1]) == -3 || (piece[1] - move[1]) == 1 || (piece[1] - move[1]) == -1){
            System.out.println("x is working");
            // If the difference between the x coordinates of the piece and where to move are within the rules
            // of movement for a knight
            if((piece[0] - move[0]) == 3 || (piece[0] - move[0]) == -3 || (piece[0] - move[0]) == 1 || (piece[0] - move[0]) == -1){
              System.out.println("Y is working");
              // Sets the original location of the piece to 'n' (null/ nothing)
              board.board[piece[1]][piece[0]] = 'n'; 
              System.out.println(board.board[piece[1]][piece[0]]);
              // Sets the location to move to, to the piece type
              board.board[move[1]][move[0]] = pieceNam; 
              // Draws the board
              board.drawBoard();
            }
          }
          break;
       case 'r':
          System.out.println("The piece choosen is a black rook");
          break;
       case 'R':
         System.out.println("The piece choosen is a white rook");
         break;
       case 'b':
         System.out.println("The piece choosen is a black bishop");
         break;
       case 'B':
         System.out.println("The piece choosen is a white bishop");
         break;
       case 'i':
         System.out.println("The piece choosen is the black king");
         break;
       case 'I':
         System.out.println("The piece choosen is the white king");
         break;
       case 'p':
          System.out.println("The piece choosen is a black pawn");
          break;
       case 'P':
         System.out.println("The piece choosen is a white pawn");
         break;
        default:
          break;
      }
   }
}