//Todo: 
//display the colors gray, yellow, green
//stop them from typing once they got the answer
//more random issues that will probably pop up out of thing air
//extra: add a win/lose screen




import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Set;

import javax.swing.*;

public class Wordle {
    public static void main(String[] args) {
        
    }
    WordList list = new WordList();
    Set<String> allValidWords = list.getSet();
    String[] words = list.getWords();
    int row = 0;
    int boardHeight = 1000;
    int boardWidth = 800;
    String answerWord = getRandomWord();

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
        textField.setDocument(new JTextFieldLimit(5));
        button.setForeground(Color.DARK_GRAY);
        button.setFont(new Font("Times New Roman", Font.BOLD, 80));
        button.setText("ENTER");
        button.setFocusable(false);
        bottomPanel.add(textField);
        bottomPanel.add(button);
        frame.add(bottomPanel, BorderLayout.SOUTH); 
        

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String word = textField.getText();
                
                if(allValidWords.contains(word)) {
                    String[] wordArr = word.split("");
                    for(int i = 0; i < 5; i++) {
                        labels[row][i].setText(wordArr[i]);
                        textField.setText("");
                    }
                    row++;
                }
                
                
            }
        });

        boardPanel.setLayout(new GridLayout(6, 5, 25, 25));
        boardPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        boardPanel.setBackground(Color.darkGray);
        frame.add(boardPanel);

        for(int r = 0; r < 6; r++) {
            for(int c = 0; c < 5; c++) {
                JLabel label = new JLabel();
                label.setOpaque(true); 
                //label.setSize(20, 20);

                label.setBackground(Color.gray);
                label.setForeground(Color.white);
                label.setFont(new Font("Times New Roman", Font.PLAIN, 80));
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setVerticalAlignment(SwingConstants.CENTER);
                // label.setText("test");

                labels[r][c] = label;
                boardPanel.add(label);
            }
        }
          
        frame.setVisible(true);
    }

    public String getRandomWord() {
        Random random = new Random();
        int length = words.length;
        int num = random.nextInt(length);
        System.out.println(words[num]);
        return words[num];
    }

}
