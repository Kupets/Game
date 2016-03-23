package ru.games.engine.object;

/**
 * Created by Crow on 09.02.2016.
 */
public abstract class Bar extends SpriteGameObject {
    private static final long serialVersionUID = 1L;

    private final int MOVE_SPEED_MODULO_IN_MILLIS = 10;

    protected Board board;

    public Bar(int x, int y, Board board) {
        super(x, y, "/bar.png");

        this.board = board;
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
