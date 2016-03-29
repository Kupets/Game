package ru.games.engine;

import ru.games.engine.object.Board;
import ru.games.engine.object.GameEvent;
import ru.games.engine.object.GameObject;
import ru.games.engine.object.Observer;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Crow on 27.01.2016.
 */
public class Game implements Runnable, Observer {
    ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
    private boolean running;
    private Board board;


    public Game() {
        board = new Board();
    }

    public final void addToGame(GameObject gameObject) {
        gameObjects.add(gameObject);
    }

    public void start() {
        running = true;
        new Thread(this).start();
    }

    public void run() {
        init();

        while(running) {
            render();
            update();
        }
    }

    private void init() {
        board.init(board);

        for(GameObject gameObject : gameObjects) {
            gameObject.init(board);
        }
    }

    private void render() {
        Graphics g = board.getGraphics();
        board.draw(g);
        for(GameObject gameObject : gameObjects) {
            gameObject.draw(g);
        }
        g.dispose();
    }

    private void update() {
        for(GameObject gameObject : gameObjects) {
            gameObject.update();
        }
    }

    @Override
    public void notify(GameObject gameObject, GameEvent event) {
        System.out.println(event.name());
    }

    public Board getBoard() {
        return board;
    }
}
