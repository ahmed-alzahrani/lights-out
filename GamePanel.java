import javax.swing.*; // used for JPanel and JLabel

// the panel that displays the user's score
public class GamePanel extends JPanel{


  private int colToDisplay = 0;

  private int rowToDisplay = 0;

  private int moveDisplay = 0;
  private JLabel columnLabel;
  private JLabel rowLabel;
  private JLabel moveLabel;

  // constructor that takes two ints representing the column/rows on the board
  public GamePanel (int boardColumns, int boardRows){
    setLayout(null);
    add(buildColumnLabel());
    add(buildRowLabel());
    add(buildMoveLabel());
    setSize(((boardColumns * 55) + 30), 60);
    setLocation(10, ((boardRows * 55) + 20));
  }


   public int getColToDisplay(){return colToDisplay;}
   public void setColToDisplay(int x){
     colToDisplay = x;
  }
  public int getRowToDisplay(){return rowToDisplay;}
  public void setRowToDisplay(int x){
    rowToDisplay = x;
  }
  public int getMoveDisplay(){return moveDisplay;}
  public void incrementMoveDisplay(){
    moveDisplay = (getMoveDisplay() + 1);
  }

  public JLabel getColumnLabel(){return columnLabel;}
  public JLabel getRowLabel(){return rowLabel;}
  public JLabel getMoveLabel(){return moveLabel;}
  public void resetAll(){
    moveDisplay = 0;
    rowToDisplay = 0;
    colToDisplay = 0;
  }
  public JLabel buildColumnLabel(){
    columnLabel = new JLabel("COL: " + this.getColToDisplay());
    columnLabel.setLocation(10, 10);
    columnLabel.setSize(80,30);
    return columnLabel;
  }

  public JLabel buildRowLabel(){
    rowLabel = new JLabel("ROW: " + this.getRowToDisplay());
    rowLabel.setLocation(10,30);
    rowLabel.setSize(80,30);
    return rowLabel;
  }

  public JLabel buildMoveLabel(){
    moveLabel = new JLabel("Moves: " + this.getMoveDisplay());
    moveLabel.setLocation(80,10);
    moveLabel.setSize(80,30);
    return moveLabel;
  }

  public void handleMove(int col, int row){
    this.setRowToDisplay(row);
    this.getRowLabel().setText("Row: " + this.getRowToDisplay());

    this.setColToDisplay(col);
    this.getColumnLabel().setText("COL: " + this.getColToDisplay());

    this.getMoveLabel().setText("Moves: " + this.getMoveDisplay());

    this.incrementMoveDisplay();
  }

}
