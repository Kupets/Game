package ru.games.engine.model;

import ru.games.engine.object.Board;
import ru.games.engine.event.Eventable;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Crow on 31.03.2016.
 */
public class TenisObjects {
    private Ball ball;
    private AiBar aiBar;
    private PlayerBar playerBar;
    private Board board;


    public TenisObjects(Board board) {
        this.board = board;

        ball = new Ball(board);
        aiBar = new AiBar(board);
        playerBar = new PlayerBar(board);
    }

    public void init() {
        ball.setX(board.getWidth() / 2);
        ball.setY(board.getHeight() / 2);

        aiBar.setX(board.getWidth() - aiBar.getWidth());
        aiBar.setY(board.getHeight() / 2);

        playerBar.setX(0);
        playerBar.setY(board.getHeight() / 2);
    }

    public List<ObjectOnBoard> getGameObjects() {
        return Arrays.asList((ObjectOnBoard)ball, aiBar, playerBar);
    }

    public Eventable getInteract() {
        return ball.getInteract();
    }
}
