package ru.games.engine.model;

import ru.games.engine.object.Board;

/**
 * Created by Crow on 09.02.2016.
 */
public abstract class Bar extends Movable {

    public Bar(Board board) {
        super("/bar.png", board);
    }
}
