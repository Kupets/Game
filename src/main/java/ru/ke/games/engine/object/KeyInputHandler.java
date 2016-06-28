package ru.ke.games.engine.object;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Crow on 31.03.2016.
 */
public class KeyInputHandler extends KeyAdapter {
    private boolean upPressed = false;
    private boolean downPressed = false;

    public void keyPressed(KeyEvent e) {
        // клавиша нажата
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        // клавиша отпущена
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
    }

    public boolean isUpPressed() {
        return upPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }
}
