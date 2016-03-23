package ru.games.engine.object;

import ru.games.engine.Sprite;

import java.awt.*;

/**
 * Created by Crow on 09.02.2016.
 */
public abstract class Bar implements GameObject {
    private final int MOVE_SPEED_MODULO_IN_MILLIS = 10;
    protected Board board;
    protected int x = 0;
    protected int y = 0;
    private Sprite bar;


    public Bar(int x, int y, Board board) {
        bar = new Sprite("/bar.png");
        this.x = x;
        this.y = y;

        this.board = board;
    }

    @Override
    public void update() {
        if(canMove()) {
            move();
        }
    }

    @Override
    public void init(Component component) {
        bar.init(component);
    }

    @Override
    public void draw(Graphics g) {
        bar.draw(g, x, y);
    }

    protected abstract void move();

    private boolean canMove() {
        return System.currentTimeMillis() % MOVE_SPEED_MODULO_IN_MILLIS == 0;
    }
}
