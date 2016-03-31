package ru.games.engine.model;

import ru.games.engine.object.Board;

import java.util.Random;

/**
 * Created by Crow on 10.03.2016.
 */
public class AiBar extends Bar {

    public AiBar(Board board) {
        super(board);
    }

    @Override
    protected void move() {
        Random random = new Random();
        boolean isUp = random.nextBoolean();
        if(isUp && getY() > 0) {
            setY(getY() - 1);
        }
        if(!isUp && getY() < board.getHeight() - 50) {
            setY(getY() + 1);
        }
    }

    @Override
    public void init() {
        super.init();

        setX(board.getWidth() - getWidth());
        setY(board.getHeight() / 2);

    }
}
