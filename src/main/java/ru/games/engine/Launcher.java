package ru.games.engine;

import ru.games.engine.object.Bar;
import ru.games.engine.object.Board;

import java.awt.*;

/**
 * Created by Crow on 09.03.2016.
 */
public class Launcher {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public static void main(String[] args) {
        Game game = new Game();

        //добавляем игровые обьекты
        Board board = new Board();
        game.addToGame(board);
        game.addToGame(new Bar(0, 0, board));
        game.addToGame(new Bar(WIDTH + 3, 0, board));

        // инициализируется техническая хрень
        game.init(board.getTitle(), new Dimension(WIDTH, HEIGHT));

        //запуск
        game.start();
    }
}
