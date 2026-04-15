import javax.swing.JFrame;

public class Pong {
    
    JFrame frame = new JFrame("Pong");

    public Pong() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 500);
        frame.setResizable(false);

        PongGame game = new PongGame();
        frame.add(game);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        
    }


}
