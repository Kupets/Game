package ru.games.engine;

import ru.games.engine.object.AiBar;
import ru.games.engine.object.Ball;
import ru.games.engine.object.Board;
import ru.games.engine.object.PlayerBar;

/**
 * Created by Crow on 09.03.2016.
 */
public class Launcher {


    public static void main(String[] args) {
        Game game = new Game();

        // добавляем игровые обьекты
        Board board = game.getBoard();
        game.addToGame(board);
        Ball ball = new Ball(board.getWidth() / 2, board.getHeight() / 2, board);
        ball.getInteract().addObserver(game);
        game.addToGame(ball);
        game.addToGame(new PlayerBar(0, board.getHeight() / 2, board));
        game.addToGame(new AiBar(board.getWidth() - 7, board.getHeight() / 2, board));

        // запуск
        game.start();
    }
}
