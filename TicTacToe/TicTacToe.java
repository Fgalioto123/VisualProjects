import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class TicTacToe {
    int boardWidth = 600;
    int boardHeight = 750; //50px for text panel on top

    JFrame frame = new JFrame("Tic-Tac-Toe");
    JLabel textLable = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();

    JButton[][] board = new JButton[3][3];
    String playerX = "X";
    String playerO = "O";
    String currentPlayer = playerX;

    JPanel restartPanel = new JPanel();
    JButton restartButton = new JButton();

    boolean gameOver = false;

    int playerWins = 0;
    JLabel winsLabel = new JLabel();


    public static void main(String[] args) {
        
    }

    TicTacToe() {
        //creating the frame
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        
        //creating the top label
        textLable.setBackground(Color.darkGray);
        textLable.setForeground(Color.white);
        textLable.setFont(new Font("Arial", Font.BOLD, 50));
        textLable.setHorizontalAlignment(JLabel.CENTER);
        textLable.setText("Tic-Tac-Toe");
        textLable.setOpaque(true);

        winsLabel.setBackground(Color.darkGray);
        winsLabel.setForeground(Color.white);
        winsLabel.setFont(new Font("Arial", Font.BOLD, 50));
        winsLabel.setHorizontalAlignment(JLabel.CENTER);
        winsLabel.setText("Player Wins: " + playerWins);
        winsLabel.setOpaque(true);

        textPanel.setLayout(new GridLayout(2, 1));
        textPanel.add(textLable);
        textPanel.add(winsLabel);
        frame.add(textPanel, BorderLayout.NORTH);

        //creating the board and restart button

        boardPanel.setLayout(new GridLayout(3, 3));
        boardPanel.setBackground(Color.darkGray);
        frame.add(boardPanel);

        restartButton.setText("Restart");
        restartButton.setFont(new Font("Arial", Font.BOLD, 20));
        restartButton.setFocusable(false);

        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });

        restartPanel.setLayout(new BorderLayout());
        restartPanel.setBackground(Color.darkGray);
        restartPanel.add(restartButton);
        frame.add(restartPanel, BorderLayout.SOUTH);
        
        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++) {
                JButton tile = new JButton();
                board[r][c] = tile;
                boardPanel.add(tile);

                tile.setBackground(Color.darkGray);
                tile.setForeground(Color.gray);
                tile.setFont(new Font("Arial", Font.BOLD, 120));
                tile.setFocusable(false);
                
                tile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (gameOver) {
                            return;
                        }
                        JButton tile = (JButton) e.getSource();
                        if(tile.getText().equals(playerO) || tile.getText().equals(playerX)) {

                        } else {
                            
                            tile.setText(currentPlayer);
                            checkWinner();
                            if(!gameOver) {
                                textLable.setText("Computers turn.");
                                Random ran = new Random();
                                int numOfLoops = 0;
                                while(numOfLoops < 10) {
                                numOfLoops++;
                                int randomRow = (int) ran.nextInt(3);
                                int ranCol = (int) ran.nextInt(3);
                                if(board[randomRow][ranCol].getText().equals("")) {
                                    board[randomRow][ranCol].setText("O");
                                    textLable.setText("X's Turn");
                                    checkWinner();
                                    break;
                                    
                                }
                            }
                            }

                            
                            

                        }
                            
                    }
                });
            }
        }

       
    }

    public void checkWinner() {
        for(int r = 0; r < 3; r++) {
            if(board[r][0].getText() == "") continue;

            if(board[r][0].getText() == board[r][1].getText() && board[r][1].getText() == board[r][2].getText()) {
                for(int i = 0; i < 3; i++) {
                    setWinner(board[r][i]);
                }
                gameOver = true;
                textLable.setText(board[r][1].getText() + " Has Won!!");
                if(board[r][1].getText().equals("X")) {
                    playerWins++;
                    winsLabel.setText("Player Wins: " + playerWins);
                }
                return;
            }
        }

        for(int c = 0; c < 3; c++) {
            if(board[0][c].getText() == "") continue;

            if(board[0][c].getText() == board[1][c].getText() && board[1][c].getText() == board[2][c].getText()) {
                gameOver = true;
                for(int i = 0; i < 3; i++) {
                    setWinner(board[i][c]);
                }
                textLable.setText(board[1][c].getText() + " Has Won!!");
                if(board[1][c].getText().equals("X")) {
                    playerWins++;
                    winsLabel.setText("Player Wins: " + playerWins);
                }
                return;
            }
        }

        if(board[0][0].getText() == board[1][1].getText() && board[1][1].getText() == board[2][2].getText() && board[0][0].getText() != "") {
            gameOver = true;
            for(int i = 0; i < 3; i++) {
                    setWinner(board[i][i]);
                }
            textLable.setText(board[0][0].getText() + " Has Won!!");
            if(board[0][0].getText().equals("X")) {
                    playerWins++;
                    winsLabel.setText("Player Wins: " + playerWins);
                }
            return;
        }

        if(board[0][2].getText() == board[1][1].getText() && board[1][1].getText() == board[2][0].getText() && board[1][1].getText() != "") {
            gameOver = true;
            for(int i = 0; i < 3; i++) {
                    setWinner(board[i][2 - i]);
                }
            textLable.setText(board[1][1].getText() + " Has Won!!");
            if(board[1][1].getText().equals("X")) {
                    playerWins++;
                    
                    winsLabel.setText("Player Wins: " + playerWins);
                }
            return;
        }

        if(checkTie()) {
            gameOver = true;
            textLable.setText("Tie!!!");
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    setLoser(board[i][j]);
                }
            }
            return;
        }
    }

    public void setWinner(JButton tile) {
        tile.setForeground(Color.green);
        tile.setBackground(Color.gray);
    }

    public void setLoser(JButton tile) {
        tile.setBackground(Color.black);
        tile.setForeground(Color.orange);
    }

    public boolean checkTie() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i][j].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    public void resetGame() {
        gameOver = false;
        textLable.setText("X's Turn");
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j].setText("");
                board[i][j].setBackground(Color.darkGray);
                board[i][j].setForeground(Color.gray);
                currentPlayer = playerX;
            }
        }
    }
}