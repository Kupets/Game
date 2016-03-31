package ru.games.engine;

import ru.games.engine.object.*;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Created by Crow on 27.01.2016.
 */
public class Game implements Runnable, Observer {
    ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
    private boolean running;
    private Board board;
    private Ball ball;
    private AiBar aiBar;
    private PlayerBar playerBar;


    public Game() {
        board = new Board();
        ball = new Ball(board);
        ball.getInteract().addObserver(this);
        aiBar = new AiBar(board);
        playerBar = new PlayerBar(board);

        setDefaultPosition(ball, aiBar, playerBar);

        // добавляем игровые обьекты
        addToGame(board);
        addToGame(ball);
        addToGame(playerBar);
        addToGame(aiBar);
    }

    private void setDefaultPosition(Ball ball,  AiBar aiBar, PlayerBar playerBar) {
        ball.setX(board.getWidth() / 2);
        ball.setY(board.getHeight() / 2);

        aiBar.setX(board.getWidth() - aiBar.getWidth());
        aiBar.setY(board.getHeight() / 2);

        playerBar.setX(0);
        playerBar.setY(board.getHeight() / 2);
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
        setDefaultPosition(ball, aiBar, playerBar);
//        board.init();
        for(GameObject gameObject : gameObjects) {
            gameObject.init();
        }
    }

    private void render() {
        Graphics g = board.getGraphics();
//        board.draw(g);
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
        if(GameEvent.WALL_INTERACT.equals(event)) {
            init();
        }
        System.out.println("Class - " + gameObject.getClass().getName() + "; Event - " + event.name() + ";");
    }

    public Board getBoard() {
        return board;
    }
}
