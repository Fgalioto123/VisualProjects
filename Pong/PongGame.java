import java.awt.*;

import javax.swing.*;

public class PongGame extends JPanel {

    public static void main(String[] args) {
        
    }

    private Ball gameBall;

    public PongGame(){

        gameBall = new Ball(300, 200, 3, 3, 3, Color.YELLOW, 10);

    }

    
    static final int WINDOW_WIDTH = 900, WINDOW_HEIGHT = 500;

    /**
     * Updates and draws all the graphics on the screen
     */
    public void paintComponent(Graphics g){

        //draw the background, set color to BLACK and fill in a rectangle
        g.setColor(Color.black);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

    }
}
