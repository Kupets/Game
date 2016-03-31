package ru.games.engine.model;

import ru.games.engine.object.Board;
import ru.games.engine.event.EventHandler;
import ru.games.engine.event.EventType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Crow on 27.01.2016.
 */
public class Game implements Runnable, EventHandler {
    List<ObjectOnBoard> objectOnBoards = new ArrayList<ObjectOnBoard>();
    private boolean running;
    private Board board;


    public Game() {
        board = new Board();

        Ball ball = new Ball(board);
        ball.getInteract().addHandler(this);
        // добавляем игровые обьекты
        addToGame(ball);
        addToGame(new PlayerBar(board));
        addToGame(new AiBar(board));
    }

    private void addToGame(ObjectOnBoard objectOnBoard) {
        objectOnBoards.add(objectOnBoard);
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
        board.init();
        for(ObjectOnBoard objectOnBoard : objectOnBoards) {
            objectOnBoard.init();
        }
    }

    private void render() {
        board.clean();
        for(ObjectOnBoard objectOnBoard : objectOnBoards) {
            objectOnBoard.getSprite().draw(board.getGraphics());
        }
        board.showObjs();
    }

    private void update() {
        for(ObjectOnBoard objectOnBoard : objectOnBoards) {
            objectOnBoard.update();
        }
    }

    public void notify(ObjectOnBoard objectOnBoard, EventType event) {
        if(EventType.WALL_INTERACT.equals(event)) {
            init();
        }
        System.out.println("Class - " + objectOnBoard.getClass().getName() + "; Event - " + event.name() + ";");
    }
}
