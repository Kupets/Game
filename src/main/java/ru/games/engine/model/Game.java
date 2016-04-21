package ru.games.engine.model;

import ru.games.engine.object.Board;
import ru.games.engine.event.EventHandler;
import ru.games.engine.event.EventType;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Crow on 27.01.2016.
 */
public class Game implements Runnable, EventHandler {
    List<ObjectOnBoard> objectOnBoards = new ArrayList<ObjectOnBoard>();
    List<Movable> interactables = new ArrayList<Movable>();
    private boolean running;
    private Board board;


    public Game() {
        board = new Board();

        Score score = new Score(board, board.getWidth() / 2, board.getHeight() / 10);

        Ball ball = new Ball(board, board.getWidth() / 2, board.getHeight() / 3);
        ball.getInteract().addHandler(this);
        ball.getInteract().addHandler(score);
//        addToGame(ball);

//        ball = new Ball(board, board.getWidth() / 2, (board.getHeight() / 3) * 2);
//        ball.getInteract().addHandler(this);
//        ball.getInteract().addHandler(score);

        // добавляем игровые обьекты
        addToGame(score);
        addToGame(ball);
        addToGame(new PlayerBar(board, 0, board.getHeight() / 2));
        addToGame(new AiBar(board, board.getWidth() - 7, board.getHeight() / 2));
    }

    private void addToGame(ObjectOnBoard objectOnBoard) {
        objectOnBoards.add(objectOnBoard);
        if(objectOnBoard instanceof Movable) {
            interactables.add((Movable)objectOnBoard);
        }
    }

    public void start() {
        running = true;
        new Thread(this).start();
    }

    public void run() {
        init();

        while(running) {
            update();
            render();
        }
    }

    private void init() {
        board.init();
        for(ObjectOnBoard objectOnBoard : objectOnBoards) {
            objectOnBoard.init();
        }
    }

    private void render() {
        //getGraphics() всегда возвращает новый инстанс
        Graphics g = board.getGraphics();
        board.clean(g);
        for(ObjectOnBoard objectOnBoard : objectOnBoards) {
            objectOnBoard.draw(g);
        }
        board.showObjs();
    }

    private void interact(ObjectOnBoard objectOnBoard) {
        if(objectOnBoard instanceof Interactable) {
            List<Movable> currentInteractables = new ArrayList<Movable>();
            currentInteractables.addAll(interactables);
            currentInteractables.remove(objectOnBoard);
            ((Interactable)objectOnBoard).interact(currentInteractables);
        }
    }

    private void update() {
        Date currentTime = new Date();
        for(ObjectOnBoard objectOnBoard : objectOnBoards) {
            interact(objectOnBoard);
            objectOnBoard.update(currentTime);
        }
    }

    public void notify(ObjectOnBoard objectOnBoard, EventType event) {
//        if(EventType.SCORE.equals(event)) {
//            init();
//        }
        System.out.println("Class - " + objectOnBoard.getClass().getName() + "; Event - " + event.name() + ";");
    }
}
