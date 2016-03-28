package ru.games.engine;

import ru.games.engine.object.GameEvent;
import ru.games.engine.object.GameObject;
import ru.games.engine.object.Observable;
import ru.games.engine.object.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

/**
 * Created by Crow on 27.01.2016.
 */
public class Game extends Canvas implements Runnable, Observer {
    ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
    private boolean running;


    public Game(String title, int width, int height) {
        setPreferredSize(new Dimension(width, height));
        // инициализируется техническая хрень
        initJFame(title);
    }

    public final void addToGame(GameObject gameObject) {
        if(gameObject instanceof Observable) {
            ((Observable)gameObject).addObserver(this);
        }
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
        BufferStrategy bs = getBufferStrategy();
        if(bs == null) {
            createBufferStrategy(3);
            requestFocus();
        }

        for(GameObject gameObject : gameObjects) {
            gameObject.init(this);
        }
    }

    private void render() {
        BufferStrategy bs = getBufferStrategy();
        // получаем Graphics из созданной нами BufferStrategy
        Graphics g = bs.getDrawGraphics();
        for(GameObject gameObject : gameObjects) {
            gameObject.draw(g);
        }
        g.dispose();
        // показать
        bs.show();
    }

    private void update() {
        for(GameObject gameObject : gameObjects) {
            gameObject.update();
        }
    }

    private void initJFame(String title) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(this, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void notify(GameObject gameObject, GameEvent event) {
        System.out.println(event.name());
    }
}
