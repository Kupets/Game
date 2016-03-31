package ru.games.engine.object;

import ru.games.engine.Sprite;

import java.awt.Graphics;

/**
 * Created by Crow on 30.03.2016.
 */
public abstract class Movable implements GameObject {
    protected int x = 0;
    protected int y = 0;
    protected int DEFAULT_MOVE_SPEED_MODULO_IN_MILLIS = 10;
    protected Sprite sprite;


    protected abstract void move();

    @Override
    public void draw(Graphics g) {
        sprite.draw(g, x, y);
    }

    @Override
    public void init() {
    }

    @Override
    public void update() {
        if(canMove()) {
            move();
        }
    }

    private boolean canMove() {
        return System.currentTimeMillis() % DEFAULT_MOVE_SPEED_MODULO_IN_MILLIS == 0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return sprite.getWidth();
    }

    public int getHeight() {
        return sprite.getHeight();
    }
}
