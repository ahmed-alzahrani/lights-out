import java.util.*;
import javax.swing.JButton;
import java.awt.Color;

// GameButtons class is a subclass of the JButton class
public class GameButtons extends JButton{
  static Color[] colors = {Color.blue, Color.yellow, Color.red, Color.white};
  // constructor
  public GameButtons(){
    setSize(50,50);
    setOpaque(true);
    colorRandom(this);
  }

  // colorRandom function randomizes the color of a JButton
  public static void colorRandom(JButton b){
    Random random = new Random();
    b.setBackground(colors[random.nextInt(4)]);
  }

    public static GameButtons[][] getGameButtons(int columns, int rows){
      GameButtons[][] gameButtons = new GameButtons[columns][rows];
      // this allows us to instantiate a button for EACH position in the array
      for (int c = 0; c < columns; c++){
        for (int r = 0; r < rows; r++){
          gameButtons[c][r] = new GameButtons();
        }
      }
      return gameButtons;
    }

    public void colorShift(){
      int index = java.util.Arrays.asList(colors).indexOf(getBackground());
      setBackground(colors[(index + 1) % 4]);
      return;
    }
  }
