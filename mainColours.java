// Ahmed Al-Zahrani
// 100900855

import javax.swing.*;

public class mainColours{
  public static void main(String[] args) {
    // code for working on MacOs to get the buttons to show up opaque as opposed to colour around the edges only
    try{
      UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
    } catch (Exception e) {
      e.printStackTrace();
    }
    // instantiates my GameBoard class as gameBoard
    // my title is simply Colours then a hint for the user, the sequence of colors the buttons move through... Blue, Yellow, Red, White
    // default array/grid i used for constructing/testing is 5x5
    // however none of my code is dependent on that, will extrapolate/interpolate for smaller/bigger grids
    GameBoard gameBoard = new GameBoard("Colours: B-Y-R-W", 5, 5);
    // set the board as visible to actually start the game!
    gameBoard.setVisible(true);
    
 }

  
}  