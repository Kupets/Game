package ru.games.engine.object;

import ru.games.engine.Sprite;

import java.awt.*;
import java.util.Random;

/**
 * Created by Crow on 09.02.2016.
 */
public class Ball extends Observable implements GameObject {
    private Board board;
    private final int MOVE_SPEED_MODULO_IN_MILLIS = 10;
    private int x = 0;
    private int y = 0;
    private int angle;
    private Sprite ball;


    public Ball(int x, int y, Board board) {
        ball = new Sprite("/ball.png");
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
        if(new Random().nextBoolean()) {
            angle = 0;
        } else {
            angle = 180;
        }
    }

    @Override
    public void draw(Graphics g) {
        ball.draw(g, x, y);
    }

    private void move() {
        x = new Long(Math.round(x + Math.cos(this.angle * Math.PI / 180))).intValue();
        y = new Long(Math.round(y + Math.sin(this.angle * Math.PI / 180))).intValue();

        if(x <= 0 || x >= board.getWidth()) {
            if(angle == 180 || angle == 0) {
                angle = new Random().nextBoolean() ? 360 - Math.abs(angle - 135) : Math.abs(angle - 135);
            } else {
                angle = 180 - angle;
                if(angle < 0)
                    angle += 360;
            }
        }

        if(y <= 0 || y >= board.getHeight()) { // 270 -> 90  269 -> 91
            angle = 360 - angle;
        }
    }

    private boolean canMove() {
        return System.currentTimeMillis() % MOVE_SPEED_MODULO_IN_MILLIS == 0;
    }
}
