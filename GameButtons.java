// Ahmed Al-Zahrani
// 100900855

import java.util.Random;   // used for randomizing int later
import javax.swing.JButton; // used for JButtons
import java.awt.Color;   // used for color of buttons

// GameButtons class is a subclass of the JButton class
public class GameButtons extends JButton{
  // color is the list of colors that the buttons COULD be
  static Color[] colors = {Color.blue, Color.yellow, Color.red, Color.white};
  // constructor
  public GameButtons(){
    // all buttons are the same size
    setSize(50,50);
    // all need to be set to Opaque
    setOpaque(true);
    //randomizes the color of the button when created
    colorRandom(this);
  }
  
  // colorRandom function randomizes the color of a JButton
  public static void colorRandom(JButton b){
    // new random to randomize an int value
    Random random = new Random();
    // x is a random int value between 0-3, coincidentally the indexes of my colors in color[] 
    int x = random.nextInt(4);
    // sets thebackground to the color at the index of the randomized number 
    b.setBackground(colors[x]);
  }
    
  // public static method getGameButtons
  // takes two ints, columns and rows and populates a 2d array called gameButtons
  // this 2d array is filled with JButtons and is the array actually used to play by the user
  // returns the array
    public static GameButtons[][] getGameButtons(int columns, int rows){
      GameButtons[][] gameButtons = new GameButtons[columns][rows];
      //gA-loop , this allows us to instantiate a button for EACH position in the array
      for (int c = 0; c < columns; c++){
        for (int r = 0; r < rows; r++){
          gameButtons[c][r] = new GameButtons();
        }
      }
      return gameButtons;
    }
    
    // public method colorShift
    // shifts the color of a given button to the next color in the array
    
    public void colorShift(){        
      
      // if the color of the button is blue, it becomes yellow, then return to end the method call
      if(getBackground() == colors[0]){
        setBackground(colors[1]);
        return;
        
        // if the color of the button is yellow, it becomes red, then return to end the method call
      } else if(getBackground() == colors[1]){
        setBackground(colors[2]);
        return;
        
        // if the color of the button is red, it becomes white then return to end the method call
      } else if(getBackground() == colors[2]){
        setBackground(colors[3]);
        return;
        
        // if the color of the button is white, it becomes blue then return to end the method call
      } else if(getBackground() == colors[3]);{
        setBackground(colors[0]);
      return;}
    } 
      
}
