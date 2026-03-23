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
    JTextField textField = new JTextField();
    JPanel bottomPanel = new JPanel();
    JButton button = new JButton();
    JLabel[][] labels = new JLabel[6][5];

    public Wordle() {
        
        frame.setSize(boardWidth, boardHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        bottomPanel.setLayout(new GridLayout(1, 2));
        bottomPanel.setBackground(Color.darkGray);
        textField.setPreferredSize(new Dimension(400, 50));
        textField.setFont(new Font("Times New Roman", Font.PLAIN, 60));
        textField.setBackground(Color.gray);
        textField.setForeground(Color.white);
        button.setForeground(Color.DARK_GRAY);
        button.setFont(new Font("Times New Roman", Font.BOLD, 80));
        button.setText("ENTER");
        button.setFocusable(false);
        bottomPanel.add(textField);
        bottomPanel.add(button);
        frame.add(bottomPanel, BorderLayout.SOUTH); 

        boardPanel.setLayout(new GridLayout(6, 5, 25, 25));
        boardPanel.setBackground(Color.darkGray);
        frame.add(boardPanel);

        for(int r = 0; r < 6; r++) {
            for(int c = 0; c < 5; c++) {
                JLabel label = new JLabel();
                label.setOpaque(true); 
                label.setSize(50, 50);

                label.setBackground(Color.gray);
                label.setForeground(Color.white);
                label.setFont(new Font("Times New Roman", Font.PLAIN, 80));
                label.setText("test");

                labels[r][c] = label;
                boardPanel.add(label);
            }
        }
          
        frame.setVisible(true);
    }

}
