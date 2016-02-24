package ru.games.engine.object;

import ru.games.engine.Sprite;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Crow on 09.02.2016.
 */
public class Bar implements GameObject {
    private static final long serialVersionUID = 1L;

    private boolean upPressed = false;
    private boolean downPressed = false;

    private int x = 0;
    private int y = 0;

    private final int MOVE_SPEED_MODULO_IN_MILLIS = 10;

    private Sprite bar;

    private Board board;

    public Bar(int x, int y, Board board) {
        this.x = x;
        this.y = y;
        this.board = board;
    }

    public void init(Component component) {
        bar = getSprite("/bar.png");
        component.addKeyListener(new KeyInputHandler());
    }

    public void draw(Graphics g) {
        bar.draw(g, x, y);
    }

    public void update() {
        if (upPressed == true && y > 0 && canMove()) {
            y--;
        }
        if (downPressed == true && y < board.getHeight() - 50 && canMove()) {
            y++;
        }
    }

    private boolean canMove() {
        return System.currentTimeMillis() % MOVE_SPEED_MODULO_IN_MILLIS == 0;
    }

    private class KeyInputHandler extends KeyAdapter {
        public void keyPressed(KeyEvent e) { //������� ������
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                upPressed = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                downPressed = true;
            }
        }

        public void keyReleased(KeyEvent e) { //������� ��������
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                upPressed = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                downPressed = false;
            }
        }
    }

    public Sprite getSprite(String path) {
        BufferedImage sourceImage = null;

        try {
            sourceImage = ImageIO.read(this.getClass().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Sprite sprite = new Sprite(Toolkit.getDefaultToolkit().createImage(sourceImage.getSource()));

        return sprite;
    }
}
