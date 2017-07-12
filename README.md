# lights-out

**The Game:**

Lights-Out is a simple game created as a class project for COMP 1405 (Intro to Computer Science) at Carleton University in the fall of 2013.

Working with JAVA, and exploring the usage of GUI elements (JFrame, JPanels etc.) as well as the concept of event handling, Lights Out is essentially a digital rubix cube.

The game initializes with a 5x5 grid of buttons that are randomized between four colours (Red, Yellow, Blue, White). Clicking on any single button will cause that button, as well as any adjacent buttons to the next colour in the array.

At the bottom of the board, the game will track both the most recently clicked button (row/col) as well as how many moves have been made so far.

To win the game, the user must turn the entire board into one single colour. The user will then be presented with the Victory Frame, informing them of their victory as well as their score (how many clicks it took).

**Compilation/Execution:**
From within the directory, use the command `javac mainColours.java` in order to compile the `.java` files into `.class` files. From there, simply `java mainColours` to launch the game.

**Advanced Tips:**

1. In order to customize the size of the game board, simply change the dimensions in the `GameBoard` constructor in `mainColours.java`

2. Because I found the game exceedingly difficult to win, I created a `testVictory()` function which, if the user clicks the FIRST button (located at 0,0 on the board) it will turn the entire board blue, thus winning the game. Currently it is commented out, but it can be uncommented at the end of the `actionPerformed(ActionEvent e)` function in `GameBoard.java`
