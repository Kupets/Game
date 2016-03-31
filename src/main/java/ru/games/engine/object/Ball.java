package ru.games.engine.object;

import ru.games.engine.Sprite;

import java.util.Random;

/**
 * Created by Crow on 09.02.2016.
 */
public class Ball extends Movable {
    private Board board;
    private Observable interact = new Observable();
    private int angle;


    public Ball(int x, int y, Board board) {
        this(board);
        this.x = x;
        this.y = y;

        this.board = board;
    }

    public Ball(Board board) {
        sprite = new Sprite("/ball.png");

        this.board = board;
    }

    @Override
    public void init() {
        DEFAULT_MOVE_SPEED_MODULO_IN_MILLIS = 10;
        if(new Random().nextBoolean()) {
            angle = 360;
        } else {
            angle = 180;
        }
    }

    @Override
    protected void move() {
        x = new Long(Math.round(x + Math.cos(this.angle * Math.PI / 180))).intValue();
        y = new Long(Math.round(y + Math.sin(this.angle * Math.PI / 180))).intValue();

        if(x <= 0 || x >= board.getWidth() - sprite.getWidth()) {
            interact.notify(this, GameEvent.OBJ_INTERACT);
            if(angle == 180 || angle == 360 || angle == 0) {
                angle = new Random().nextBoolean() ? 360 - Math.abs(angle - 135) : Math.abs(angle - 135);
                DEFAULT_MOVE_SPEED_MODULO_IN_MILLIS *= 1.5;
            } else {
                angle = 180 - angle;
                if(angle < 0)
                    angle += 360;
            }
        }

        if(y <= 0 || y >= board.getHeight() - sprite.getHeight()) { // 270 -> 90  269 -> 91
            interact.notify(this, GameEvent.WALL_INTERACT);
            angle = 360 - angle;
        }
    }

    public Observable getInteract() {
        return interact;
    }
}
