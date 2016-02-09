package ru.engine;

import ru.engine.object.Bar;
import ru.engine.object.Board;

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

    ArrayList<GameListener> gameListeners = new ArrayList<GameListener>();

    public final void addToGame(GameListener gameListener) {
        gameListeners.add(gameListener);
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

        for(GameListener gameListener : gameListeners) {
            gameListener.init(this);
        }
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        Graphics g = bs.getDrawGraphics(); //получаем Graphics из созданной нами BufferStrategy
        for(GameListener gameListener : gameListeners) {
            gameListener.draw(g);
        }
        g.dispose();
        bs.show(); //показать
    }

    public void update() {
        for(GameListener gameListener : gameListeners) {
            gameListener.update();
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        Board board = new Board();
        game.addToGame(board);
        game.addToGame(new Bar(0, 0, board));
        game.addToGame(new Bar(WIDTH + 3, 0, board));

        game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        initJFame(game, board);

        game.start();
    }

    private static void initJFame(Game game, Board board) {
        JFrame frame = new JFrame(board.getTitle());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(game, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
