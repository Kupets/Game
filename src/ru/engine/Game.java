package ru.engine;

import ru.engine.object.Bar;
import ru.engine.object.Board;
import ru.engine.object.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

/**
 * Created by Crow on 27.01.2016.
 */
public class Game extends Canvas implements Runnable {
    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private boolean running;

    ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

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

    public void init() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            requestFocus();
        }

        for(GameObject gameObject : gameObjects) {
            gameObject.init(this);
        }
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        Graphics g = bs.getDrawGraphics(); //получаем Graphics из созданной нами BufferStrategy
        for(GameObject gameObject : gameObjects) {
            gameObject.draw(g);
        }
        g.dispose();
        bs.show(); //показать
    }

    public void update() {
        for(GameObject gameObject : gameObjects) {
            gameObject.update();
        }
    }

    public static void main(String[] args) {
        Game game = new Game();

        //добавляем игровые обьекты
        Board board = new Board();
        game.addToGame(board);
        game.addToGame(new Bar(0, 0, board));
        game.addToGame(new Bar(WIDTH + 3, 0, board));

        //интциализируется техническая хрень
        game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        initJFame(game, board.getTitle());

        //запуск
        game.start();
    }

    private static void initJFame(Component component, String title) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(component, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
