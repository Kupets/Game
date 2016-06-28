package ru.ke.games.engine.model;

import ru.ke.games.engine.event.EventHandler;
import ru.ke.games.engine.event.EventType;
import ru.ke.games.engine.object.Board;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.util.Date;

/**
 * Created by Crow on 20.04.2016.
 */
public class Score implements ObjectOnBoard, EventHandler {
    private Board board;
    private int leftScore = 0;
    private int rightScore = 0;
    private int x = 0;
    private int y = 0;

    AffineTransform affinetransform = new AffineTransform();
    FontRenderContext frc = new FontRenderContext(affinetransform,true,true);
    Font font = new Font("Tahoma", Font.PLAIN, 24);

    public Score(Board board) {
        this.board = board;
    }

    public Score(Board board, int x, int y) {
        this.board = board;
        this.x = x;
        this.y = y;
    }

    public void init() {
    }

    public void update(Date currentTime) {
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.setFont(font);
        g.drawString(getScore(), x, y);
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

    public String getScore() {
        return leftScore + " : " + rightScore;
    }

    public int getWidth() {
        return ((int)font.getStringBounds(getScore(), frc).getWidth());
    }

    public int getHeight() {
        return ((int)font.getStringBounds(getScore(), frc).getHeight());
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
