package ru.games.engine.object;

/**
 * Created by Crow on 09.02.2016.
 */
public class Ball extends SpriteGameObject {
    private Board board;

    private final int MOVE_SPEED_MODULO_IN_MILLIS = 10;

    public Ball(int x, int y, Board board) {
        super(x, y, "/ball.png");

        this.board = board;
    }

    public void update() {
        if(canMove()) {
            move();
        }
    }

    private void move() {

    }

    private boolean canMove() {
        return System.currentTimeMillis() % MOVE_SPEED_MODULO_IN_MILLIS == 0;
    }
}
