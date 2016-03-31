package ru.games.engine.model;

import ru.games.engine.object.Board;
import ru.games.engine.object.KeyInputHandler;

/**
 * Created by Crow on 10.03.2016.
 */
public class PlayerBar extends Bar {
    private KeyInputHandler keyInputHandler = new KeyInputHandler();


    public PlayerBar(Board board) {
        super(board);
    }

    @Override
    public void init() {
        super.init();

        setX(0);
        setY(board.getHeight() / 2);
        board.addKeyListener(keyInputHandler);
    }

    @Override
    protected void move() {
        if(keyInputHandler.isUpPressed() == true && getY() > 0) {
            setY(getY() - 1);
        } else if(keyInputHandler.isDownPressed() == true && getY() < board.getHeight() - 50) {
            setY(getY() + 1);
        }
    }
}
