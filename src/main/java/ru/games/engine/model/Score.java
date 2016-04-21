package ru.games.engine.model;

import ru.games.engine.event.EventHandler;
import ru.games.engine.event.EventType;
import ru.games.engine.object.Board;

import java.awt.*;
import java.util.Date;

/**
 * Created by Crow on 20.04.2016.
 */
public class Score implements ObjectOnBoard, EventHandler {
    private Board board;
    private int leftScore = 0;
    private int rightScore = 0;
    private int x;
    private int y;

    public Score(Board board, int x, int y) {
        this.board = board;
        this.x = x;
        this.y = y;
    }

    public void init() {}

    public void update(Date currentTime) {}

    public void draw(Graphics g) {
        Font serifFont = new Font("Courier New", Font.BOLD, 24);
        g.setColor(Color.white);
        g.setFont(serifFont);
        g.drawString(leftScore + " : " + rightScore, x, y);
    }

    public void notify(ObjectOnBoard objectOnBoard, EventType event) {
        if(EventType.SCORE.equals(event)) {
            if(((Ball)objectOnBoard).getX() <= 0) {
                leftScore++;
            } else if(((Ball)objectOnBoard).getX() >= board.getWidth() - ((Ball)objectOnBoard).getWidth()) {
                rightScore++;
            }
        }
    }

    public Board getBoard() {
        return board;
    }
}
