import javax.swing.*;
import java.awt.event.*;

public class VictoryFrame extends JFrame{
  public VictoryFrame(String title,int score){
    super(title);
    setLayout(null);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    //button for disposing (works like clicking the close button)
    JButton endButton = new JButton("Play again");
    endButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        dispose();
      }
    });
    add(endButton);

    //label for displaying the message with a number
    JLabel label = new JLabel("You Won in "+score+" moves!");
    label.setSize(150,20);
    label.setLocation(10,30);
    endButton.setLocation(15,60);
    endButton.setSize(120,30);
    add(label);


    setSize(170,150);
  }
}
