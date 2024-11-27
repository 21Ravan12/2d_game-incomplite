package Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed,jumpPressed,shiftPressed;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
         int key = e.getKeyCode();

//         if (key == KeyEvent.VK_W) {
//             upPressed = true;
//         }
         if (key == KeyEvent.VK_A) {
             leftPressed = true;

         }
//         if (key == KeyEvent.VK_S) {
//             downPressed = true;
//         }
         if (key == KeyEvent.VK_D) {
             rightPressed = true;

         }
         if (key == KeyEvent.VK_J) {
             jumpPressed = true;
         }
         if (key == KeyEvent.VK_SHIFT) {
             shiftPressed = true;
         }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

//        if (key == KeyEvent.VK_W) {
//            upPressed = false;
//        }
        if (key == KeyEvent.VK_A) {
            leftPressed = false;

        }
//        if (key == KeyEvent.VK_S) {
//            downPressed = false;
//        }
        if (key == KeyEvent.VK_D) {
            rightPressed = false;

        }
        if (key == KeyEvent.VK_J) {
            jumpPressed = false;
        }
        if (key == KeyEvent.VK_SHIFT) {
            shiftPressed = false;
        }
    }
}
