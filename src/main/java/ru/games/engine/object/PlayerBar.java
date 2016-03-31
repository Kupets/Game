package ru.games.engine.object;

import ru.games.engine.KeyInputHandler;

import java.awt.Component;

/**
 * Created by Crow on 10.03.2016.
 */
public class PlayerBar extends Bar {
    private KeyInputHandler keyInputHandler = new KeyInputHandler();


    public PlayerBar(int x, int y, Board board) {
        super(x, y, board);
    }

    public PlayerBar(Board board) {
        super(board);
    }

    @Override
    public void init() {
        super.init();
        board.addKeyListener(keyInputHandler);
    }

    @Override
    protected void move() {
        if(keyInputHandler.isUpPressed() == true && y > 0) {
            y--;
        } else if(keyInputHandler.isDownPressed() == true && y < board.getHeight() - 50) {
            y++;
        }
    }
}
