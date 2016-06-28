package ru.ke.games.engine;

import ru.ke.games.engine.model.Game;

/**
 * Created by Crow on 09.03.2016.
 */
public class Launcher {

    public static void main(String[] args) {
        Game game = new Game();
        // запуск
        game.start();
    }
}
