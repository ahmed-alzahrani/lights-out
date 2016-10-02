// Ahmed Al-Zahrani
// 100900855


import javax.swing.JFrame;   // used for JFrame
import java.awt.event.*;     // used for event Handling


public class GameBoard extends JFrame implements ActionListener{
  //gameArray is an array of JButtons representing the buttons the user interacts with
  private GameButtons[][] gameArray; 
  //columns is the number of columns on the gameBoard
  private int columns;
  //number of rows on the gameBoard
  private int rows;
  //the panel that displays the user's score and most recent guess
  private GamePanel panel;
  //VictoryFrame, the frame that reports the user's win 
  private VictoryFrame vFrame; 
  
  
  //GameBoard constructor, takes 3 params string title then 2 ints representing columns and rows
  public GameBoard(String title, int col, int row){
    // calls the JFrame superclass constructor with the title provided
    super(title);
    // sets columns to the int provided as the columns, nicknamed "col"
    columns = col;
    // same concept as columns but with rows
    rows = row;
    //nullifies the layout managers
    getContentPane().setLayout(null);
    // uses the getGameButtons method from the GameButtons class to populate the gameArray 2d array of JButtons (GameButtons) 
    gameArray = GameButtons.getGameButtons(columns, rows);
    //loops through gameArray, we will see a LOT of these, from here on out referred to as gA-loop***********
     for (int c = 0; c < columns; c++){
        for (int r = 0; r < rows; r++){
          //sets the location of EACH button relative to which button it is on the board
          gameArray[c][r].setLocation((10 + (55*c)), 10 + (55*r));
          //add the buttons so they appear on the board
          add(gameArray[c][r]);
          //adds the actionListener to each button as it gets added onto the board
          gameArray[c][r].addActionListener(this);
        }
     }
     // instantiates an instance of the GamePanel class called panel
     // panel will AUTOMATICALLY match the GameBoard for size because it references columns and rows in the constructor
      panel = new GamePanel(columns, rows);
      //adds the panel to the Frame
     add(panel);    
  
     //defines the frame's exit behavior
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     //sets the size relative to the size of the board the player is playing on 
     setSize(((columns * 55) + 30), ((rows * 55) + 120));
     //disallows the user from resizing the Frame
     setResizable(false);     
} 
  // actionPerformed, the handler that actually affects the game when a button is clicked
  public void actionPerformed(ActionEvent e){
    // again our gA-loop, used whenever we need to do something to ALL buttons in the array
      for (int c = 0; c < columns; c++) {
      for (int r = 0; r < rows; r++) {
        // the below if statement is a piece of debugging code used to test if my game could recognize and appropriately respond to win conditions
         //if (e.getSource() == gameArray[0][0]){
           //testVictory();}
        
        //if the source of the click is one of our buttons in the array
        if ( e.getSource() == gameArray[c][r]) {
          //shif the color of the pressed button using our colorShift method from the GameButtons class
          gameArray[c][r].colorShift();
          
          // use our setter from the panel to change the rowDisplay to the row value (r) of the last button clicked
          panel.setRowToDisplay(r);
          // set the text of the label itself by getting the label and getting the rowdisplay value we changed in the previous line
          panel.getRowLabel().setText("ROW: " + panel.getRowToDisplay());
          
          //the same logic as above, but with the columns (c) value
          panel.setColToDisplay(c);
          panel.getColumnLabel().setText("COL: " + panel.getColToDisplay());
          
          // uses the incrementMoveDisplay() method to make sure the moves are +1 each time a button is clicked
          panel.incrementMoveDisplay();
          // same logic as above but with the the # of moves the user has made
          panel.getMoveLabel().setText("Moves: " + panel.getMoveDisplay());
          // here is how we integrate the board's ability to change the color of buttons ADJACENT to the button clicked
          // if c+1 is less than columns, there IS a button directly above the button pressed
          if(c+1 < columns){
            // we shift the color of the above button
            gameArray[c+1][r].colorShift();
          }
          // if c-1 >= 0, there IS a button directly below the button pressed
          if(c-1 >= 0){
            // shift the color of the button pressed
            gameArray[c-1][r].colorShift();
          }
          // if r+1 < rows, we KNOW there is an available button directly to the right of the pressed button
          if(r+1 < rows){
            // shift that color
            gameArray[c][r+1].colorShift();
          }
          //if r-1 is greater than or equal to zero we KNOW there is a button directly to the left of the pressed button
          if(r-1 >= 0){
            // shift its color
            gameArray[c][r-1].colorShift();
          }
        }
      }
    }
      
      // isComplete method, evaluates whether the user has won the game
      if (isComplete()){
        // instantiate our VictoryFrame class as variable vFrame
        // the title is Winner! and its passed the # of moves the user has made as a param
        vFrame = new VictoryFrame("Winner!", panel.getMoveDisplay());
        // set it to visible if the user wins
        vFrame.setVisible(true);
        // gA-loop, we need to randomize the color of EVERY button in the array
        for (int c = 0; c < columns; c++){
          for(int r = 0; r < rows; r++){
            // randomizes their color
            GameButtons.colorRandom(gameArray[c][r]);
          }
        }
        // we then reset the panel values with our resetAll method found in the GamePanel class
        panel.resetAll();
        
       }
  }
  

  // our isComplete() function, returns true if the user has won, false if not
  public boolean isComplete(){
    //gA loop, we want to look at EVERY button in the array to determine wheteher a win has occured
    for(int c = 0; c < columns; c++){
      for(int r = 0; r < rows; r++){
        // a win occurs if all buttons are the same
        // therefore if we compare one solitary button vs every other button we get our answer
        // here I compare the button at [0][0] (first button) against ALL other buttons in the array
        // if just one button doesn't have the same color background as the initial button, it isn't a win
        if ( gameArray[0][0].getBackground() != gameArray[c][r].getBackground()){
          // so we return false
          return false;
        }
      }
    }
    // if we made it through the previous gA-loop without finding a single button that is different than the original, the user has won
    // returns true
    return true;
  }
  // test method i used to help ensure that my game functions properly
  // takes no parameters and outputs no values
  // however, it does set all of the buttons in the array to the exact same color (blue)
  public void testVictory(){
    // gA loop to affect all buttons
    for(int c = 0; c < columns; c++){
      for(int r = 0; r < rows; r++){
        // sets their background to blue
        gameArray[c][r].setBackground(GameButtons.colors[0]);
      }
    }
  }
       
}
      
  
  
  

    
    
    
        
        
      
    
    
    
    
    
    
    
  
  