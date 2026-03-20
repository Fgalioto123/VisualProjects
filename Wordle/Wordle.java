//Todo: need to add the tiles to the grid (and need to figure out if they should be buttons or something else) and then let the player type and erase on those tiles 
//they can hit enter if there are 5 letters and it is a word in the row. it will then display the colors.
//it will then take them to the next line until they either win or lose 
//extra: add a win/lose screen
//add a start screen
//add a on screen keyboard


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Wordle {
    public static void main(String[] args) {
        
    }

    int boardHeight = 1000;
    int boardWidth = 800;

    JFrame frame = new JFrame("Wordle");
    JPanel boardPanel = new JPanel();

    public Wordle() {
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        boardPanel.setLayout(new GridLayout(5, 6));
        boardPanel.setBackground(Color.darkGray);
        frame.add(boardPanel);
    }
}
