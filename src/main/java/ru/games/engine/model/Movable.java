package ru.games.engine.model;

import ru.games.engine.object.Board;
import ru.games.engine.object.Sprite;

/**
 * Created by Crow on 30.03.2016.
 */
public abstract class Movable implements ObjectOnBoard {
    protected int DEFAULT_MOVE_SPEED_MODULO_IN_MILLIS = 10;
    protected Sprite sprite;
    protected Board board;


    public Movable(String spritePath, Board board) {
        sprite = new Sprite(spritePath);
        this.board = board;
    }

    protected abstract void move();

    public void init() {
    }

    public void update() {
        if(canMove()) {
            move();
        }
    }

    public Board getBoard() {
        return board;
    }

    public Sprite getSprite() {
        return sprite;
    }

    private boolean canMove() {
        return System.currentTimeMillis() % DEFAULT_MOVE_SPEED_MODULO_IN_MILLIS == 0;
    }

    public int getX() {
        return this.sprite.getX();
    }

    public void setX(int x) {
        this.sprite.setX(x);
    }

    public int getY() {
        return this.sprite.getY();
    }

    public void setY(int y) {
        this.sprite.setY(y);
    }

    public int getWidth() {
        return sprite.getWidth();
    }

    public int getHeight() {
        return sprite.getHeight();
    }
}
