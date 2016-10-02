// Ahmed Al-Zahrani
// 100900855


import javax.swing.*; // used for JPanel and JLabel

// the panel that displays the user's score
public class GamePanel extends JPanel{
  
  // column of user's last guess
  private int colToDisplay = 0;
  // row of user's last guess
  private int rowToDisplay = 0;
  // # of moves used
  private int moveDisplay = 0;
  // the column label displaying the latest column picked (the label itself, the previous int was the value)
  private JLabel columnLabel;
  // the row label displaying the latest row picked (the label itself, the previous int was the value)
  private JLabel rowLabel;
  // the move label dsiplaying the # of moves picked (the label itself, the previous int was the value)
  private JLabel moveLabel;  
   
  // constructor that takes two ints representing the column/rows on the board
  // this will automatically match up with the columns/rows on the board
  // when this class is instantiated in GameBoard it is passed the board's values for columns/rows as the columns/rows for the Panel
  public GamePanel (int boardColumns, int boardRows){
    // disables layout manager
    setLayout(null);
    
    // Column Label is built, showing COL: 0 for a guess in column 0 etc
    columnLabel = new JLabel("COL: " + colToDisplay);
    // sets the location on the panel
    columnLabel.setLocation(10, 10);
    // sets the size of the label
    columnLabel.setSize(80,30);
    // adds it to the panel
    add(columnLabel);
    
    // row label is built, showing ROW: 0 for a guess in row 0 etc
    rowLabel = new JLabel("ROW: " + rowToDisplay);
    // sets the location of the label
    rowLabel.setLocation(10,30);
    // set the size of the label
    rowLabel.setSize(80,30);
    // adds it to the panel
    add(rowLabel);
    
    // instantiates the moveLabel showing Moves: 9 if 9 moves have been made etc
    moveLabel = new JLabel("Moves: " + moveDisplay);
    // sets location
    moveLabel.setLocation(80,10);
    // sets the size of the label
    moveLabel.setSize(80,30);
    // adds it to the panel
    add(moveLabel);
    
    // sets the size of the Panel relative to the size of the board (columns/rows)
    setSize(((boardColumns * 55) + 30), 60);
    
    // sets the location of the panel, how far down it is is dependent on the number of rows on the board
    setLocation(10, ((boardRows * 55) + 20));
  }
  
  // a getter for the column to display, or the column of user's latest guess
   public int getColToDisplay(){return colToDisplay;}
   
   // a setter for the column of the user's latest guess, this lets us change the display of the label depending on their guess
   public void setColToDisplay(int x){
     colToDisplay = x;
  }
  
   // same logic as above, but with the row of the user's guess
  public int getRowToDisplay(){return rowToDisplay;}
  public void setRowToDisplay(int x){
    rowToDisplay = x;
  }
  
  // same logic as above, but with the number of moves made
  public int getMoveDisplay(){return moveDisplay;}
  
  // the moves made can't jump like the user's guess can, it can only incremenet by 1
  // this function does that for us
  public void incrementMoveDisplay(){
    moveDisplay = (getMoveDisplay() + 1);
  }
  
  
  // more getters but this time for the labels themselves instead of the values
  public JLabel getColumnLabel(){return columnLabel;}
  
  public JLabel getRowLabel(){return rowLabel;}
  
  public JLabel getMoveLabel(){return moveLabel;}
   
  // method resetAll() to reset the user's score as well as their previous guess for if they win the game
  // sets all values to 0
  public void resetAll(){
    moveDisplay = 0;
    rowToDisplay = 0;
    colToDisplay = 0;
  }
  
  
 
}
