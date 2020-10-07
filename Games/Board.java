
public class Board {
  public void drawBoard(){
    for( int i = 8; i > 0; i--){
      System.out.println(i + " | | | | | | | | |");
    }
    System.out.println("   A B C D E F G H");
  }
}