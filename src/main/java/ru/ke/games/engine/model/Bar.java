package ru.ke.games.engine.model;

import ru.ke.games.engine.object.Board;

/**
 * Created by Crow on 09.02.2016.
 */
public abstract class Bar extends Movable {

    public Bar(Board board, int x, int y) {
        super("/bar.png", board, x, y);
    }
}
