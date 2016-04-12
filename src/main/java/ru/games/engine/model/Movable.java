package ru.games.engine.model;

import ru.games.engine.object.Board;
import ru.games.engine.object.Sprite;

import java.util.Date;

/**
 * Created by Crow on 30.03.2016.
 */
public abstract class Movable implements ObjectOnBoard {
    protected int DEFAULT_MOVE_SPEED_MODULO_IN_MILLIS;
    protected Sprite sprite;
    protected Board board;
    protected Date lastUpdate = new Date();
    protected int startX = 0;
    protected int startY = 0;


    public Movable(String spritePath, Board board, int x, int y) {
        sprite = new Sprite(spritePath);
        startX = x;
        sprite.setX(startX);
        startY = y;
        sprite.setY(startY);
        this.board = board;
    }

    protected abstract void move();

    public void init() {
        DEFAULT_MOVE_SPEED_MODULO_IN_MILLIS = 2;

        setX(startX);
        setY(startY);
    }

    public void update(Date currentTime) {
        if(canMove(currentTime)) {
            move();
        }
    }

    public Board getBoard() {
        return board;
    }

    public Sprite getSprite() {
        return sprite;
    }

    private boolean canMove(Date currentTime) {
        boolean canMove = false;
        if(currentTime.getTime() - lastUpdate.getTime() >= DEFAULT_MOVE_SPEED_MODULO_IN_MILLIS) {
            canMove = true;
            lastUpdate = currentTime;
        }

        return canMove;
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
