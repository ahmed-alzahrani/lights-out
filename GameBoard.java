import javax.swing.JFrame;   // used for JFrame
import java.awt.event.*;     // used for event Handling


public class GameBoard extends JFrame implements ActionListener{
  private GameButtons[][] gameArray;
  private int columns;
  private int rows;
  private GamePanel panel;
  private VictoryFrame vFrame;


  //GameBoard constructor, takes 3 params string title then 2 ints representing columns and rows
  public GameBoard(String title, int col, int row){
    // calls the JFrame superclass constructor with the title provided
    super(title);
    columns = col;
    rows = row;
    getContentPane().setLayout(null);
    gameArray = GameButtons.getGameButtons(columns, rows);
     for (int c = 0; c < columns; c++){
        for (int r = 0; r < rows; r++){
          gameArray[c][r].setLocation((10 + (55*c)), 10 + (55*r));
          add(gameArray[c][r]);
          //adds the actionListener to each button as it gets added onto the board
          gameArray[c][r].addActionListener(this);
        }
     }
      panel = new GamePanel(columns, rows);
     add(panel);

     //defines the frame's exit behavior
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     //sets the size relative to the size of the board the player is playing on
     setSize(((columns * 55) + 30), ((rows * 55) + 120));
     setResizable(false);
}
  public void actionPerformed(ActionEvent e){
      for (int c = 0; c < columns; c++) {
      for (int r = 0; r < rows; r++) {
        /*
        if (e.getSource() == gameArray[0][0]){
          testVictory();
        }
        */
        if ( e.getSource() == gameArray[c][r]) {
          gameArray[c][r].colorShift();
          panel.handleMove(c, r);
          shiftAdjacent(c, r);
        }
      }
    }

      if (isComplete()){
        vFrame = new VictoryFrame("Winner!", panel.getMoveDisplay());
        vFrame.setVisible(true);
        // gA-loop, we need to randomize the color of EVERY button in the array
        for (int c = 0; c < columns; c++){
          for(int r = 0; r < rows; r++){
            GameButtons.colorRandom(gameArray[c][r]);
          }
        }
        panel.resetAll();

       }
  }


  // our isComplete() function, returns true if the user has won, false if not
  public boolean isComplete(){
    for(int c = 0; c < columns; c++){
      for(int r = 0; r < rows; r++){
        if ( gameArray[0][0].getBackground() != gameArray[c][r].getBackground()){
          return false;
        }
      }
    }
    return true;
  }

  // auto-win method for testing
  public void testVictory(){
    for(int c = 0; c < columns; c++){
      for(int r = 0; r < rows; r++){
        gameArray[c][r].setBackground(GameButtons.colors[0]);
      }
    }
  }

  public void shiftAdjacent(int col, int row) {
    if(col+1 < columns){
      gameArray[col+1][row].colorShift();
    }
    if(col-1 >= 0){
      gameArray[col-1][row].colorShift();
    }
    if(row+1 < rows){
      gameArray[col][row+1].colorShift();
    }
    if(row-1 >= 0){
      gameArray[col][row-1].colorShift();
    }

  }

}
