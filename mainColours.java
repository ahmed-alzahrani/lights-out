import javax.swing.*;

public class mainColours{
  public static void main(String[] args) {
    try{
      UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
    } catch (Exception e) {
      e.printStackTrace();
    }
    GameBoard gameBoard = new GameBoard("Colours: B-Y-R-W", 5, 5);
    // set the board as visible to actually start the game!
    gameBoard.setVisible(true);
 }
}
