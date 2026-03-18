import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe {
    int boardWidth = 600;
    int boardHeight = 650; //50px for text panel on top

    JFrame frame = new JFrame("Tic-Tac-Toe");
    JLabel textLable = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();

    JButton[][] board = new JButton[3][3];
    String playerX = "X";
    String playerO = "O";
    String currentPlayer = playerX;

    boolean gameOver = false;

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

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLable);
        frame.add(textPanel, BorderLayout.NORTH);

        //creating the board
        boardPanel.setLayout(new GridLayout(3, 3));
        boardPanel.setBackground(Color.darkGray);
        frame.add(boardPanel);
        

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
                                currentPlayer = currentPlayer == playerX ? playerO : playerX;
                                textLable.setText(currentPlayer + "'s turn.");
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
                return;
            }
        }

        if(board[0][0].getText() == board[1][1].getText() && board[1][1].getText() == board[2][2].getText() && board[0][0].getText() != "") {
            gameOver = true;
            for(int i = 0; i < 3; i++) {
                    setWinner(board[i][i]);
                }
            textLable.setText(board[0][0].getText() + " Has Won!!");
            return;
        }

        if(board[0][2].getText() == board[1][1].getText() && board[1][1].getText() == board[2][0].getText() && board[1][1].getText() != "") {
            gameOver = true;
            for(int i = 0; i < 3; i++) {
                    setWinner(board[i][2 - i]);
                }
            textLable.setText(board[1][1].getText() + " Has Won!!");
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
}