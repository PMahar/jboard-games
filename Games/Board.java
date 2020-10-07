package games;

public class Board {
  public void drawBoard(){
    for( int i = 8; i > 0; i--){
      System.out.println(i + " | | | | | | | | |");
    }
  }
}