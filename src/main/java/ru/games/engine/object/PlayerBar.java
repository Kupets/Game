package ru.games.engine.object;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Crow on 10.03.2016.
 */
public class PlayerBar extends Bar {
    private boolean upPressed = false;
    private boolean downPressed = false;


    public PlayerBar(int x, int y, Board board) {
        super(x, y, board);
    }

    @Override
    public void init(Component component) {
        super.init(component);
        component.addKeyListener(new KeyInputHandler());
    }

    @Override
    protected void move() {
        if(upPressed == true && y > 0) {
            y--;
        }
        if(downPressed == true && y < board.getHeight() - 50) {
            y++;
        }
    }

    private class KeyInputHandler extends KeyAdapter {
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
    }
}
