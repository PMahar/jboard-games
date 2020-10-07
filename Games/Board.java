
public class Board {
  Main main = new Main();
  public void drawBoard(){
    for( int i = 8; i > 0; i--){
      System.out.println(i + " |" + main.pieces.get(i*1) +"| | | | | | | |");
    }
    System.out.println("   A B C D E F G H");
  }
}