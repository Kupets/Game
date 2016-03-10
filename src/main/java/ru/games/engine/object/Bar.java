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
public abstract class Bar implements GameObject {
    private static final long serialVersionUID = 1L;

    protected int x = 0;
    protected int y = 0;

    private final int MOVE_SPEED_MODULO_IN_MILLIS = 10;

    private Sprite bar;

    protected Board board;

    public Bar(int x, int y, Board board) {
        this.x = x;
        this.y = y;
        this.board = board;
    }

    public void init(Component component) {
        bar = getSprite("/bar.png");
    }

    private Sprite getSprite(String path) {
        BufferedImage sourceImage = null;

        try {
            sourceImage = ImageIO.read(this.getClass().getResourceAsStream(path));
        } catch(IOException e) {
            e.printStackTrace();
        }

        Sprite sprite = new Sprite(Toolkit.getDefaultToolkit().createImage(sourceImage.getSource()));

        return sprite;
    }

    public void draw(Graphics g) {
        bar.draw(g, x, y);
    }

    public void update() {
        if(canMove()) {
            move();
        }
    }

    protected abstract void move();

    private boolean canMove() {
        return System.currentTimeMillis() % MOVE_SPEED_MODULO_IN_MILLIS == 0;
    }
}
