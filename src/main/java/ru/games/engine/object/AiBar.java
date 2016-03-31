package ru.games.engine.object;

import java.util.Random;

/**
 * Created by Crow on 10.03.2016.
 */
public class AiBar extends Bar {

    public AiBar(int x, int y, Board board) {
        super(x, y, board);
    }

    public AiBar(Board board) {
        super(board);
    }

    @Override
    protected void move() {
        Random random = new Random();
        boolean isUp = random.nextBoolean();
        if(isUp && y > 0) {
            y--;
        }
        if(!isUp && y < board.getHeight() - 50) {
            y++;
        }
    }
}
