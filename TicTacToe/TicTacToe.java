import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe {
    int boardWidth = 600;
    int boardHeight = 650; //50px for text panel on top

    JFrame frame = new JFrame();
    JLabel textLable = new JLabel();
    JPanel textPanel = new JPanel();

    public static void main(String[] args) {
        
    }

    TicTacToe() {
        frame.setSize(boardWidth, boardHeight);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        
        textLable.setBackground(Color.darkGray);
        textLable.setForeground(Color.white);
        textLable.setFont(new Font("Arial", Font.BOLD, 50));
        textLable.setHorizontalAlignment(JLabel.CENTER);
        textLable.setText("Tic-Tac-Toe");
        textLable.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLable);
        frame.add(textPanel, BorderLayout.NORTH);
    }
}