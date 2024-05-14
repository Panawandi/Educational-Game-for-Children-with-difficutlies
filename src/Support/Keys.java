package Support;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keys implements KeyListener {

    public Keys() {
        return;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key){
            case KeyEvent.VK_ESCAPE:
                System.out.println("You quit the program");
                System.exit(0);
                break;
        }
        System.out.println("Key pressed: " + e.getKeyChar());
        switch (key){
            }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
