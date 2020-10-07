
public class Board {
  Main main = new Main();
  public void drawBoard(){
    for(int x = 0; x < 8; x++){
     // This is just to test if the "board" works 
      main.pieces.add("n");
    }
    for( int i = 8; i > 0; i--){
      System.out.println(i + " |" + main.pieces.get(i-1) +"| | | | | | | |");
    }
    System.out.println("   A B C D E F G H");
  }
}