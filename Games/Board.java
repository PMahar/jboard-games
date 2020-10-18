import java.util.Scanner;
import java.lang.Math;

public class Board {
  //TODO: We still need to add a feature for castling.
  //We can resurrect checkSurround later, as the rook's range is dependent on the position of
  //other pieces, and all pieces except knight can't pass others
  Main main = new Main();
  int ans;
  int turn = 0;
  // The White peices are capital and black pieces are lowercase
  // Matrix board will contain information on the location and types of pieces, if there are no pieces it 
  // will show "n"  
  // Char[][] board is the matrix that has all of the information on what
  // pieces are where and what pieces they are
  // The char 'i' is representitive of the king piece
  // board[y][x]
  public char[][] board =
  {{'r','k','b','i','q','b','k','r'},
  {'p','p','p','p','p','p','p','p'},
  {'n','n','n','n','n','n','n','n'},
  {'n','n','n','n','n','n','n','n'},
  {'n','n','n','n','n','n','n','n'},
  {'n','n','n','n','n','n','n','n'},
  {'P','P','P','P','P','P','P','P'},
  {'R','K','B','I','Q','B','K','R'}};
  /**
   * This draws the board
   * */
  public void drawBoard(){
    for(int i = 8; i > 0; i--){
      System.out.println(i + " |" + board[i - 1][0] + "|" + board[i - 1][1] + "|" + board[i - 1][2] + "|" + board[i - 1][3] + "|"
      + board[i - 1][4] + "|" + board[i - 1][5] + "|" + board[i - 1][6] + "|" + board[i - 1][7] + "|");
    }
    // Print the labels for each part of the board
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
    int distX = piece[0] - move[0]; // This is the distance that the piece needs to move in the X-ax
    int distY = piece[1] - move[1]; // This is the distance that the piece needs to move in the Y-axis
    int motX = Math.abs((piece[0] - move[0]));
    int motY = Math.abs((piece[1] - move[1])); //Grab distance from chosen piece to target
    // If the location to move to doesn't have any piece there then move onto the next step of moving a piece
    //Else, if the spot contains the other player's piece, knock the piece over
    //Else, break
    if(board[move[1]][move[0]] == 'n'){
      // Sets a char variable "pieceNam" to the value of the piece to be moved
      char pieceNam = board[piece[1]][piece[0]];
      switch(pieceNam) {
        case 'r':
          System.out.println("The piece chosen is a black rook");
		  if((motX > 0) && (motY > 0)) {
			System.out.println(board[piece[0]][piece[1]] + " at (" + piece[0] + "," + piece[1] + ") to (" + move[0] + ", " 
			+ move[1] + ") - Invalid move: Out of selected piece's range");
		break;
		  } else {
//          if(checkSurround(piece,move,pieceNam) ==1) {
            System.out.println("This should be doing this: " + board[piece[1]][piece[0]] + " to " + board[move[1]][move[0]]);
            board[piece[1]][piece[0]] = 'n';
            board[move[1]][move[0]] = pieceNam;
            drawBoard();
            System.out.println(pieceNam);
//          } else {
//            System.out.println("method checkSurround failed");
//          }
		  }
		break;
        case 'R':
          System.out.println("The piece chosen is a white rook");
		  if((motX > 0) && (motY > 0)) {
			System.out.println(board[piece[0]][piece[1]] + " at (" + piece[0] + "," + piece[1] + ") to (" + move[0] + ", " 
			+ move[1] + ") - Invalid move: Out of selected piece's range");
		break;
		  } else {
//          if(checkSurround(piece,move,pieceNam) ==1) {
            System.out.println("This should be doing this: " + board[piece[1]][piece[0]] + " to " + board[move[1]][move[0]]);
            board[piece[1]][piece[0]] = 'n';
            board[move[1]][move[0]] = pieceNam;
            drawBoard();
            System.out.println(pieceNam);
//          } else {
//            System.out.println("method checkSurround failed");
//          }
		  }
        break;
        case 'k':
          System.out.println("The piece chosen is a black knight");
//          if(checkSurround(piece,move,pieceNam) ==1) {
            if ((motX == 2 && motY == 1) || (motX == 1 && motY == 2)) {
              System.out.println("This should be doing this: " + board[piece[1]][piece[0]] + " to " + board[move[1]][move[0]]);
              board[piece[1]][piece[0]] = 'n';
              board[move[1]][move[0]] = pieceNam;
              drawBoard();
              System.out.println(pieceNam);
            } else {
                System.out.println(board[piece[0]][piece[1]] + " at (" + piece[0] + "," + piece[1] + ") to (" + move[0] + ", " + move[1] +
                ") - Invalid move: Out of selected piece's range");
            }
//          } else {
//            System.out.println("method checkSurround failed");
//          }
		break;
        case 'K':
          System.out.println("The piece chosen is a white knight");
//          if(checkSurround(piece,move,pieceNam) ==1) {
            if ((motX == 2 && motY == 1) || (motX == 1 && motY == 2)) {
              System.out.println("This should be doing this: " + board[piece[1]][piece[0]] + " to " + board[move[1]][move[0]]);
              board[piece[1]][piece[0]] = 'n';
              board[move[1]][move[0]] = pieceNam;
              drawBoard();
              System.out.println(pieceNam);
            } else {
                System.out.println(board[piece[0]][piece[1]] + " at (" + piece[0] + "," + piece[1] + ") to (" + move[0] + ", " + move[1] +
                ") - Invalid move: Out of selected piece's range");
            }
//          } else {
//            System.out.println("method checkSurround failed");
//          }
		break;
        case 'b':
          System.out.println("The piece choosen is a black bishop");
		  if (motX != motY) {
			System.out.println(board[piece[0]][piece[1]] + " at (" + piece[0] + "," + piece[1] + ") to (" + move[0] + ", " 
			+ move[1] + ") - Invalid move: Out of selected piece's range");
		break;
		  } else {
//          if(checkSurround(piece,move,pieceNam) ==1) {
            System.out.println("This should be doing this: " + board[piece[1]][piece[0]] + " to " + board[move[1]][move[0]]);
            board[piece[1]][piece[0]] = 'n';
            board[move[1]][move[0]] = pieceNam;
            drawBoard();
            System.out.println(pieceNam);
//          } else {
//            System.out.println("method checkSurround failed");
//          }
		  }
        break;
        case 'B':
          System.out.println("The piece choosen is a white bishop");
		  if (motX != motY) {
			System.out.println(board[piece[0]][piece[1]] + " at (" + piece[0] + "," + piece[1] + ") to (" + move[0] + ", " 
			+ move[1] + ") - Invalid move: Out of selected piece's range");
		break;
		  } else {
//          if(checkSurround(piece,move,pieceNam) ==1) {
            System.out.println("This should be doing this: " + board[piece[1]][piece[0]] + " to " + board[move[1]][move[0]]);
            board[piece[1]][piece[0]] = 'n';
            board[move[1]][move[0]] = pieceNam;
            drawBoard();
            System.out.println(pieceNam);
//          } else {
//            System.out.println("method checkSurround failed");
//          }
		  }
        break;
        case 'i':
          System.out.println("The piece chosen is a black king");
//          if(checkSurround(piece,move,pieceNam) ==1) {
            if ((motX == 1) || (motY == 1) || (motX == 1 && motY == 1)) {
              System.out.println("This should be doing this: " + board[piece[1]][piece[0]] + " to " + board[move[1]][move[0]]);
              board[piece[1]][piece[0]] = 'n';
              board[move[1]][move[0]] = pieceNam;
              drawBoard();
              System.out.println(pieceNam);
            } else {
                System.out.println(board[piece[0]][piece[1]] + " at (" + piece[0] + "," + piece[1] + ") to (" + move[0] + ", " + move[1] +
                ") - Invalid move: Out of selected piece's range");
            }
			break;
        case 'I':
          System.out.println("The piece chosen is a white king");
//          if(checkSurround(piece,move,pieceNam) ==1) {
            if ((motX == 1) || (motY == 1) || (motX == 1 && motY == 1)) {
              System.out.println("This should be doing this: " + board[piece[1]][piece[0]] + " to " + board[move[1]][move[0]]);
              board[piece[1]][piece[0]] = 'n';
              board[move[1]][move[0]] = pieceNam;
              drawBoard();
              System.out.println(pieceNam);
            } else {
                System.out.println(board[piece[0]][piece[1]] + " at (" + piece[0] + "," + piece[1] + ") to (" + move[0] + ", " + move[1] +
                ") - Invalid move: Out of selected piece's range");
            }
			break;
        case 'q':
          System.out.println("The piece choosen is a black queen");
		  if((motX > 0) && (motY > 0) && (motX != motY)) {
			System.out.println(board[piece[0]][piece[1]] + " at (" + piece[0] + "," + piece[1] + ") to (" + move[0] + ", " 
			+ move[1] + ") - Invalid move: Out of selected piece's range");
		break;
		  } else {
//          if(checkSurround(piece,move,pieceNam) ==1) {
            System.out.println("This should be doing this: " + board[piece[1]][piece[0]] + " to " + board[move[1]][move[0]]);
            board[piece[1]][piece[0]] = 'n';
            board[move[1]][move[0]] = pieceNam;
            drawBoard();
            System.out.println(pieceNam);
//          } else {
//            System.out.println("method checkSurround failed");
//          }
		  }
        break;
        case 'Q':
          System.out.println("The piece choosen is a white queen");
		  if((motX > 0) && (motY > 0) && (motX != motY)) {
			System.out.println(board[piece[0]][piece[1]] + " at (" + piece[0] + "," + piece[1] + ") to (" + move[0] + ", " 
			+ move[1] + ") - Invalid move: Out of selected piece's range");
		break;
		  } else {
//          if(checkSurround(piece,move,pieceNam) ==1) {
            System.out.println("This should be doing this: " + board[piece[1]][piece[0]] + " to " + board[move[1]][move[0]]);
            board[piece[1]][piece[0]] = 'n';
            board[move[1]][move[0]] = pieceNam;
            drawBoard();
            System.out.println(pieceNam);
//          } else {
//            System.out.println("method checkSurround failed");
//          }
		  }
        break;
        case 'p':
          System.out.println("The piece chosen is a black pawn");
//          if(checkSurround(piece,move,pieceNam) == 1) {
            if ((motX == 1) || (motY == 1)|| (motY == 2)) {
              System.out.println("This should be doing this: " + board[piece[1]][piece[0]] + " to " + board[move[1]][move[0]]);
              board[piece[1]][piece[0]] = 'n';
              board[move[1]][move[0]] = pieceNam;
              drawBoard();
              System.out.println(pieceNam);
            } else {
//              System.out.println("motX wasn't equal to 2 or 1 at 236");
                System.out.println(board[piece[0]][piece[1]] + " at (" + piece[0] + "," + piece[1] + ") to (" + move[0] + ", " + move[1] +
                ") - Invalid move: Out of selected piece's range");
            }
//          } else {
//            System.out.println("method checkSurround at 235 failed");
//          }
          break;
        case 'P':
          System.out.println("The piece chosen is a white pawn");
//          if(checkSurround(piece,move,pieceNam) ==1) {
            if ((motX == 1) || (motY == 1) || (motY == 1) || (motY == 2)) {
              System.out.println("This should be doing this: " + board[piece[1]][piece[0]] + " to " + board[move[1]][move[0]]);
              board[piece[1]][piece[0]] = 'n';
              board[move[1]][move[0]] = pieceNam;
              drawBoard();
              System.out.println(pieceNam);
            } else {
                System.out.println(board[piece[0]][piece[1]] + " at (" + piece[0] + "," + piece[1] + ") to (" + move[0] + ", " + move[1] +
                ") - Invalid move: Out of selected piece's range");
            }
//          } else {
//            System.out.println("method checkSurround failed");
//          }
          break;
        default:
          break;
      }
    } else if (board[move[0]][move[1]] == 'P' || board[move[0]][move[1]] == 'R' || board[move[0]][move[1]] == 'K' || board[move[0]][move[1]] == 'B'
              || board[move[0]][move[1]] == 'Q' || board[move[0]][move[1]] == 'I') {
       System.out.println("Knocked over piece " + board[move[0]][move[1]] + " at " + move[0] + ", " + move[1]);
    } else {
       System.out.println(piece[0] + ", " + piece[1] + " to " + move[0] + ", " + move[1] + ": Invalid move, piece in the way!");
       }
      drawBoard();
    }

  /**
   * This is used to check the surroundings to see if a piece can move without interfering with another piece
   * @param int[] piece is the x and y coordinates of the piece 
   * @param int[] moveTo is the desired location for the piece to go to
   * @param char type is the type of piece to be looked around
   * */
  private int checkSurround(int[] piece, int[] moveTo, char type){
    int distX = piece[0] - moveTo[0]; // This is the distance that the piece needs to move in the X-ax
    int distY = piece[1] - moveTo[1]; // This is the distance that the piece needs to move in the Y-axis
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
    // If the piece is a bishop
    if(type == 'b' || type == 'B'){
      // Check all possible locations for a piece that would interfere
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
    // If the piece is a pawn
    if( type == 'p' || type == 'P'){
      // Check all of the possible moves to see if any have piece that would make a move invalid
      for(int i = -distY; i < distY; i++){
        System.out.println(" i = " + i + " distY = " + distY);
        for(int j = -distX; j < distX; j++){
          System.out.println("j = " + j + " distX = " + distX);
          // If the selected piece is empty than set variable ans to 1
          System.out.println(board[piece[1]][piece[0]+i]);
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
