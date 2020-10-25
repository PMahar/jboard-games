import java.util.Scanner;
import java.lang.Math;

public class Board {
  // TODO: We still need to add a feature for castling.
  // We can resurrect checkSurround later, as the rook's range is dependent on the position of
  // other pieces, and all pieces except knight can't pass others
  char pieceNam;
  Main main = new Main();
  int ans;
  int turn = 1; // This is used for knowing how many turns there have been and who's turn it is
  int pMove = 0;
  int PMove = 0;
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
    // Print out the board
    for(int i = 8; i > 0; i--){
      // Output the board and pieces into the console
      System.out.println(i + " |" + board[i - 1][0] + "|" + board[i - 1][1] + "|" + board[i - 1][2] + "|" + board[i - 1][3] + "|"
      + board[i - 1][4] + "|" + board[i - 1][5] + "|" + board[i - 1][6] + "|" + board[i - 1][7] + "|");
    }
    // Print the labels for each part of the board
    System.out.println("   A B C D E F G H");
    System.out.println();
    String turnState; // This is used for turn logic
    // If the current turn is even, then output ": Black's move"
    if (turn%2 == 0) {
      turnState = "Turn " + turn + ": Black's move";
      // Else if the current turn is an odd number, then output ": White's move"
    } else {
      turnState = "Turn " + turn + ": White's move"; 
    }
    // Print whether it's black's turn or white's turn to move
    System.out.println(turnState);
    // Create the scanner so we can use the input of the user
    Scanner sc = new Scanner(System.in);
    System.out.println("Pick a piece (X-coord A-H where A = 1):");
    // This is the X coordinate for the piece to be moved
    int pieceX = sc.nextInt() - 1;
	System.out.println();
    System.out.println("Pick a piece (Y-coord 1-8):");
    // This is the Y coordinate for the piece to be moved
    int pieceY = sc.nextInt() - 1; 
	System.out.println();
    // This is the array for combined coordinates of pieceX and pieceY
    int[] pin = {pieceX, pieceY}; 
	System.out.println("Selected piece " + board[(pieceY)][(pieceX)] + " at " + (pieceX + 2) + ", " + (pieceY + 2));
    System.out.println("Pick where to move the piece to (X-coord A-H where A = 1): ");
	System.out.println("Or, type 10 to cancel.");
    // This is the X coordinate for where to move the piece to
    int moveX = sc.nextInt() - 1;
	System.out.println();
	if (moveX == 9) {
		drawBoard();
	} else {
      System.out.println("Pick where to move the piece to (Y-coord 1-8):");
      // This is the Y coordinate for where to move the piece to
      int moveY = sc.nextInt() - 1; 
	  System.out.println();
      int[] min = {moveX, moveY}; // This is the array for the combined coordinates of moveX and moveY
      inputMove(pin, min); // This puts action to the players inputs
	}
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
    // Else, if the spot contains the other player's piece, knock the piece over
    // Else, break
    if(board[move[1]][move[0]] == 'n'){
      // Sets a char variable "pieceNam" to the value of the piece to be moved
      pieceNam = board[piece[1]][piece[0]];
    }
    // This is where all the checks for movement
	switch(pieceNam) {
		case 'n' :
			System.out.println("Please select a piece.");
			drawBoard();
			break;
		default:
		switch(pieceNam) {
		case 'r':
			System.out.println("The piece chosen is a black rook");
			System.out.println();
			if((motX > 0) && (motY > 0)) {
			System.out.println(board[piece[0]][piece[1]] + " at (" + piece[0] + "," + piece[1] + 
								") to (" + move[0] + ", "+ move[1] + ") - Invalid move: Out of selected piece's range");
			break;
			} else {
			System.out.println("This should be doing this: " + board[piece[1]][piece[0]] + " to " + board[move[1]][move[0]]);
			board[piece[1]][piece[0]] = 'n';
			board[move[1]][move[0]] = pieceNam;
			turn++;
			drawBoard();
			}
			break;
		case 'R':
			System.out.println("The piece chosen is a white rook");
			System.out.println();
			if((motX > 0) && (motY > 0)) {
			System.out.println(board[piece[0]][piece[1]] + " at (" + piece[0] + "," + piece[1] + ") to (" + move[0] + ", " 
								+ move[1] + ") - Invalid move: Out of selected piece's range");
			break;
			} else {
			System.out.println("This should be doing this: " + board[piece[1]][piece[0]] + " to " + board[move[1]][move[0]]);
			board[piece[1]][piece[0]] = 'n';
			board[move[1]][move[0]] = pieceNam;
			turn++;
			drawBoard();
			}
			break;
		case 'k':
			System.out.println("The piece chosen is a black knight");
			System.out.println();
			if ((motX == 2 && motY == 1) || (motX == 1 && motY == 2)) {
			System.out.println("This should be doing this: " + board[piece[1]][piece[0]] + " to " + board[move[1]][move[0]]);
			board[piece[1]][piece[0]] = 'n';
			board[move[1]][move[0]] = pieceNam;
			turn ++;
			drawBoard();
			} else {
			System.out.println(board[piece[0]][piece[1]] + " at (" + piece[0] + "," + piece[1] + ") to (" + move[0] + ", " + move[1] +
								") - Invalid move: Out of selected piece's range");
			}
			break;
		case 'K':
			System.out.println("The piece chosen is a white knight");
			System.out.println();
			if ((motX == 2 && motY == 1) || (motX == 1 && motY == 2)) {
			System.out.println("This should be doing this: " + board[piece[1]][piece[0]] + " to " + board[move[1]][move[0]]);
			board[piece[1]][piece[0]] = 'n';
			board[move[1]][move[0]] = pieceNam;
			turn++;
			drawBoard();
			} else {
			System.out.println(board[piece[0]][piece[1]] + " at (" + piece[0] + "," + piece[1] + ") to (" + move[0] + ", " + move[1] +
								") - Invalid move: Out of selected piece's range");
			}
			break;
		case 'b':
			System.out.println("The piece chosen is a black bishop");
			System.out.println();
			if (motX != motY) {
			System.out.println(board[piece[0]][piece[1]] + " at (" + piece[0] + "," + piece[1] + ") to (" + move[0] + ", " 
								+ move[1] + ") - Invalid move: Out of selected piece's range");
			break;
			} else {
			System.out.println("This should be doing this: " + board[piece[1]][piece[0]] + " to " + board[move[1]][move[0]]);
			board[piece[1]][piece[0]] = 'n';
			board[move[1]][move[0]] = pieceNam;
			turn++;
			drawBoard();
			}
			break;
		case 'B':
			System.out.println("The piece chosen is a white bishop");
			System.out.println();
			if (motX != motY) {
			System.out.println(board[piece[0]][piece[1]] + " at (" + piece[0] + "," + piece[1] + ") to (" + move[0] + ", " 
								+ move[1] + ") - Invalid move: Out of selected piece's range");
			break;
			} else {
			System.out.println("This should be doing this: " + board[piece[1]][piece[0]] + " to " + board[move[1]][move[0]]);
			board[piece[1]][piece[0]] = 'n';
			board[move[1]][move[0]] = pieceNam;
			turn++;
			drawBoard();
			}
			break;
		case 'i':
			System.out.println("The piece chosen is a black king");
			System.out.println();
			if ((motX == 1) || (motY == 1) || (motX == 1 && motY == 1)) {
			System.out.println("This should be doing this: " + board[piece[1]][piece[0]] + " to " + board[move[1]][move[0]]);
			board[piece[1]][piece[0]] = 'n';
			board[move[1]][move[0]] = pieceNam;
			turn++;
			drawBoard();
			} else {
			System.out.println(board[piece[0]][piece[1]] + " at (" + piece[0] + "," + piece[1] + ") to (" + move[0] + ", " + move[1] +
								") - Invalid move: Out of selected piece's range");
			}
			break;
		case 'I':
			System.out.println("The piece chosen is a white king");
			System.out.println();
			if ((motX == 1) || (motY == 1) || (motX == 1 && motY == 1)) {
			System.out.println("This should be doing this: " + board[piece[1]][piece[0]] + " to " + board[move[1]][move[0]]);
			board[piece[1]][piece[0]] = 'n';
			board[move[1]][move[0]] = pieceNam;
			turn++;
			drawBoard();
			} else {
			System.out.println(board[piece[0]][piece[1]] + " at (" + piece[0] + "," + piece[1] + ") to (" + move[0] + ", " + move[1] +
								") - Invalid move: Out of selected piece's range");
			}
			break;
		case 'q':
			System.out.println("The piece chosen is a black queen");
			System.out.println();
			if((motX > 0) && (motY > 0) && (motX != motY)) {
			System.out.println(board[piece[0]][piece[1]] + " at (" + piece[0] + "," + piece[1] + ") to (" + move[0] + ", " 
								+ move[1] + ") - Invalid move: Out of selected piece's range");
			break;
			} else {
			System.out.println("This should be doing this: " + board[piece[1]][piece[0]] + " to " + board[move[1]][move[0]]);
			board[piece[1]][piece[0]] = 'n';
			board[move[1]][move[0]] = pieceNam;
			turn++;
			drawBoard();
			}
			break;
		case 'Q':
			System.out.println("The piece chosen is a white queen");
			System.out.println();
			if((motX > 0) && (motY > 0) && (motX != motY)) {
			System.out.println(board[piece[0]][piece[1]] + " at (" + piece[0] + "," + piece[1] + ") to (" + move[0] + ", " 
				+ move[1] + ") - Invalid move: Out of selected piece's range");
			break;
			} else {
			System.out.println("This should be doing this: " + board[piece[1]][piece[0]] + " to " + board[move[1]][move[0]]);
			board[piece[1]][piece[0]] = 'n';
			board[move[1]][move[0]] = pieceNam;
			turn++;
			drawBoard();
			}
			break;
		case 'p':
			System.out.println("The piece chosen is a black pawn");
			System.out.println();
			if ((motX == 1) || (motY == 1) || (motX == 2) || (motY == 2)){
			System.out.println("This should be doing this: " + board[piece[1]][piece[0]] + " to " + board[move[1]][move[0]]);
			board[piece[1]][piece[0]] = 'n';
			board[move[1]][move[0]] = pieceNam;
			if (move[1] == 7) {
				System.out.println("PAWN PROMOTION: Select a rank to promote your pawn to:");
				Scanner pS = new Scanner(System.in);
				char promRank = pS.next().charAt(0);
				if (promRank != 'r' || promRank != 'k' || promRank != 'b' || promRank != 'q') {
					System.out.println("Invalid rank : " + promRank + " - Please select a different rank.");
				} else {
					board[move[1]][move[0]] = promRank;  
				}
			}
			turn++;
			drawBoard();
			break;
			} else {
			System.out.println(board[piece[0]][piece[1]] + " at (" + piece[0] + "," + piece[1] + ") to (" + move[0] + ", " + move[1] +
								") - Invalid move: Out of selected piece's range");
			}
			break;
		case 'P':
			System.out.println("The piece chosen is a white pawn");
			System.out.println();
			if ((motX == 1) || (motY == 1) || (motX == 2) || (motY == 2)){
			System.out.println("This should be doing this: " + board[piece[1]][piece[0]] + " to " + board[move[1]][move[0]]);
			board[piece[1]][piece[0]] = 'n';
			board[move[1]][move[0]] = pieceNam;
			if (move[1] == 7) {
				System.out.println("PAWN PROMOTION: Select a rank to promote your pawn to:");
				Scanner pS = new Scanner(System.in);
				char promRank = pS.next().charAt(0);
				if (promRank != 'R' || promRank != 'K' || promRank != 'B' || promRank != 'Q') {
					System.out.println("Invalid rank : " + promRank + " - Please select a different rank.");
				} else {
					board[move[1]][move[0]] = promRank;  
				}
			}
			turn ++;
			drawBoard();
			break;
			} else {
			System.out.println(board[piece[0]][piece[1]] + " at (" + piece[0] + "," + piece[1] + ") to (" + move[0] + ", " + move[1] +
								") - Invalid move: Out of selected piece's range");
			}
			break;
		default:
			break;	
		}
	}	
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