import java.util.Scanner;

public class Board {
  
  // These are to make moving pieces a little bit easier
  private int a = 0;
  private int b = 1;
  private int c = 2;
  private int d = 3;
  private int e = 4;
  private int f = 5;
  private int g = 6;
  private int h = 7;
  private int ans;
  
  Main main = new Main();
  // The White peices are capital and black pieces are lowercase
  // Matrix board will contain information on the location and types of pieces, if there are no pieces it 
  // will show "n"  
  // Char[][] board is the matrix that has all of the information on what
  // pieces are where and what pieces they are
  // The char 'i' is representitive of the king piece
  // board[y][x]
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
    inputMove(pin, min); // This puts action to the players inputs
  }
    
  
  /**
   * 
   * @param piece is the first array given and is the coordinates for the piece to be moved
   * @param moveTo is the second array given and will be checked to see if there is a pre-existing piece
   * */
  public void inputMove(int[] piece, int[] move){
    // If the location to move to doesn't have any piece there then move onto the next step of moving a piece
    if(board[move[1]][move[0]] == 'n'){
      // Sets a char variable "pieceNam" to the value of the piece to be moved
      char pieceNam = board[piece[1]][piece[0]];
      switch(pieceNam){
        case 'k':
          // movement for a knight
          if((piece[1] - move[1]) == 2 || (piece[1] - move[1]) == -2 || (piece[1] - move[1]) == 1 || (piece[1] - move[1]) == -1){
            // If the difference between the x coordinates of the piece and where to move are within the rules
            // of movement for a knight
            if((piece[0] - move[0]) == 2 || (piece[0] - move[0]) == -2 || (piece[0] - move[0]) == 1 || (piece[0] - move[0]) == -1){
              // Sets the original location of the piece to 'n' (null/ nothing)
              board[piece[1]][piece[0]] = 'n'; 
              // Sets the location to move to, to the piece type
              board[move[1]][move[0]] = pieceNam; 
              // Draws the board
              drawBoard();
            } else {
             System.out.println("Invalid move");
             drawBoard();
            }
          } else {
           System.out.println("Invalid move");
           drawBoard();
          }
          break;
       case 'K':
          System.out.println("The piece chosen is a white knight");
          // If the difference between the x coordinates of the piece and where to move are within the rules of 
          // movement for a knight
          if((piece[1] - move[1]) == 2 || (piece[1] - move[1]) == -2 || (piece[1] - move[1]) == 1 || (piece[1] - move[1]) == -1){
            // If the difference between the x coordinates of the piece and where to move are within the rules
            // of movement for a knight
            if((piece[0] - move[0]) == 2 || (piece[0] - move[0]) == -2 || (piece[0] - move[0]) == 1 || (piece[0] - move[0]) == -1){
              // Sets the original location of the piece to 'n' (null/ nothing)
              board[piece[1]][piece[0]] = 'n'; 
              // Sets the location to move to, to the piece type
              board[move[1]][move[0]] = pieceNam; 
              // Draws the board
              drawBoard();
            } else {
              System.out.println("Invalid move!"); 
              drawBoard();
            }
          } else {
           System.out.println("Invalid move!");
           drawBoard();
          }
          break;
       case 'r':
         System.out.println("The piece choosen is a black rook");
         if(checkSurround(piece, move,pieceNam) == 1){
           // Sets the original location of the piece to 'n' (null/ nothing)
           board[piece[1]][piece[0]] = 'n'; 
           // Sets the location to move to, to the piece type
           board[move[1]][move[0]] = pieceNam;
           // Draws the board
           drawBoard();
         } else {
          System.out.println("Invalid move!");
          drawBoard();
         }
         break;
       case 'R':
         System.out.println("The piece choosen is a white rook");
         if(checkSurround(piece,move,pieceNam) == 1){
           // Sets the original location of the piece to 'n' (null/ nothing)
           board[piece[1]][piece[0]] = 'n'; 
           // Sets the location to move to, to the piece type
           board[move[1]][move[0]] = pieceNam;
           // Draws the board
           drawBoard();
         } else {
           System.out.println("Invalid move!");
           drawBoard();
         }
         break;
       case 'b':
         System.out.println("The piece choosen is a black bishop");
         if(checkSurround(piece,move,pieceNam) == 1){
           // Sets the original location of the piece to 'n' (null/ nothing)
           board[piece[1]][piece[0]] = 'n'; 
           // Sets the location to move to, to the piece type
           board[move[1]][move[0]] = pieceNam;
           // Draws the board
           drawBoard();
         } else {
           System.out.println("Invalid move!");
           drawBoard();
         }
         break;
       case 'B':
         System.out.println("The piece choosen is a white bishop");
         if(checkSurround(piece,move,pieceNam) == 1){
           // Sets the original location of the piece to 'n' (null/ nothing)
           board[piece[1]][piece[0]] = 'n'; 
           // Sets the location to move to, to the piece type
           board[move[1]][move[0]] = pieceNam;
           // Draws the board
           drawBoard();
         } else {
           System.out.println("Invalid move!");
           drawBoard();
         }
         break;
       case 'i':
         System.out.println("The piece choosen is the black king");
         // Sets the original location of the piece to 'n' (null/ nothing)
         board[piece[1]][piece[0]] = 'n'; 
         // Sets the location to move to, to the piece type
         board[move[1]][move[0]] = pieceNam;
         // Draws the board
         drawBoard();
         break;
       case 'I':
         System.out.println("The piece choosen is the white king");
         // Sets the original location of the piece to 'n' (null/ nothing)
         board[piece[1]][piece[0]] = 'n'; 
         // Sets the location to move to, to the piece type
         board[move[1]][move[0]] = pieceNam;
         // Draws the board
         drawBoard();
         break;
       case 'p':
         System.out.println("The piece choosen is a black pawn");
         // Sets the original location of the piece to 'n' (null/ nothing)
         board[piece[1]][piece[0]] = 'n'; 
         // Sets the location to move to, to the piece type
         board[move[1]][move[0]] = pieceNam;
         // Draws the board
         drawBoard();
         break;
       case 'P':
         System.out.println("The piece choosen is a white pawn");
         // Sets the original location of the piece to 'n' (null/ nothing)
         board[piece[1]][piece[0]] = 'n'; 
         // Sets the location to move to, to the piece type
         // Draws the board
         drawBoard();
         break;
       default:
          break;
      }
    }
   // Draws the board
   drawBoard();
   }
  
  /**
   * This is used to check the surroundings to see if a piece can move without interfering with another piece
   * @param int[] piece is the x and y coordinates of the piece 
   * @param int[] moveTo is the desired location for the piece to go to
   * @param char type is the type of piece to be looked around
   * */
  private int checkSurround(int[] piece, int[] moveTo, char type){
   int distX = piece[1] - moveTo[1]; // This is the distance that the piece needs to move in the X-ax
   int distY = piece[0] - moveTo[0]; // This is the distance that the piece needs to move in the Y-axis
   int up; // The amount of spaces upwards a piece can move
   int down; // The amount of spaces down a piece can move 
   int left; // The amount of spaces to the left a piece can move
   int right; // The amount of spaces to the right a piece can move
   int diagUpRight; // The amount of spaces a piece can move diagonally upwards and to the right
   int diagUpLeft; // The amount of spaces a piece can move diagonally upwards and to the left
   int diagDownRight; // The amount of spaces a piece can move diagonally downwards and to the right
   int diagDownLeft; // The amount of spaces a piece can move diagonally downwards and to the left
   // If the piece is a rook then continue into the body
   if( type == 'r' || type == 'R'){
     for (int i = distY; i < distY; i++){
       for(int j = distX; j < distX; j++){
         // If the selected piece is empty then set variable ans to 1
         if(board[piece[1]+j][piece[0]+i] == 'n'){
           System.out.println("Valid so far at " + piece[1] + " " + piece[0]);
           ans = 1;
         }
       } 
     }
   }
   if(type == 'b' || type == 'B'){
     for (int i = distY; i < distY; i++){
       for(int j = distX; j < distX; j++){
         System.out.println(piece[1] + " " + piece[0]);
         // If the selected piece is empty than set variable ans to 1
         if(board[piece[1]+j][piece[0]+i] == 'n'){
           System.out.println("Valid at " + piece[1] + " " + piece[0]);
           ans = 1;
         }
       }
     }
   }
   return ans;
  }
}
