package ru.games.engine.object;

import ru.games.engine.Sprite;

/**
 * Created by Crow on 09.02.2016.
 */
public abstract class Bar extends Movable {
    protected Board board;


    public Bar(int x, int y, Board board) {
        this(board);
        this.x = x;
        this.y = y;

        this.board = board;
    }

    public Bar(Board board) {
        sprite = new Sprite("/bar.png");

        this.board = board;
    }
}
