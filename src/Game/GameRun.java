package Game;

import javax.swing.JFrame;


public class GameRun {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setTitle("mymy2d");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GamePanel gameplay = new GamePanel();
        frame.add(gameplay);

        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(true);
        gameplay.startGameThread();





    }


}

