package ru.games.engine.object;

import ru.games.engine.Sprite;

import java.awt.*;

/**
 * Created by Crow on 09.02.2016.
 */
public class Ball implements GameObject {
    private Board board;
    private final int MOVE_SPEED_MODULO_IN_MILLIS = 10;
    private int x = 0;
    private int y = 0;
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
        ball.init(component);
    }

    @Override
    public void draw(Graphics g) {
        ball.draw(g, x, y);
    }

    private void move() {

    }

    private boolean canMove() {
        return System.currentTimeMillis() % MOVE_SPEED_MODULO_IN_MILLIS == 0;
    }
}
