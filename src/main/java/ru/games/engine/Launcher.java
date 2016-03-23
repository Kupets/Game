package ru.games.engine;

import ru.games.engine.object.AiBar;
import ru.games.engine.object.Ball;
import ru.games.engine.object.Board;
import ru.games.engine.object.PlayerBar;

/**
 * Created by Crow on 09.03.2016.
 */
public class Launcher {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public static void main(String[] args) {
        Game game = new Game(WIDTH, HEIGHT);

        // добавляем игровые обьекты
        Board board = new Board(WIDTH, HEIGHT);
        game.addToGame(board);
        game.addToGame(new Ball(WIDTH/2, HEIGHT/2, board));
        game.addToGame(new PlayerBar(0, HEIGHT/2, board));
        game.addToGame(new AiBar(WIDTH + 3, HEIGHT/2, board));

        // запуск
        game.start();
    }
}
