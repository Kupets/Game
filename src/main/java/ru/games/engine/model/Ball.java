package ru.games.engine.model;

import ru.games.engine.object.Board;
import ru.games.engine.event.EventType;
import ru.games.engine.event.Eventable;

import java.util.List;
import java.util.Random;

/**
 * Created by Crow on 09.02.2016.
 */
public class Ball extends Movable implements Interactable {
    private Eventable interact = new Eventable();
    private int angle;


    public Ball(Board board, int x, int y) {
        super("/ball.png", board, x, y);
    }

    @Override
    public void init() {
        super.init();

        if(new Random().nextBoolean()) {
            angle = 360;
        } else {
            angle = 180;
        }
    }

    private void changeAngle() {
        if(angle == 180 || angle == 360 || angle == 0) {
            angle = new Random().nextBoolean() ? 360 - Math.abs(angle - 135) : Math.abs(angle - 135);
            DEFAULT_MOVE_SPEED_MODULO_IN_MILLIS *= 1.5;
        } else {
            angle = 180 - angle;
            if(angle < 0) {
                angle += 360;
            }
        }
    }

    @Override
    protected void move() {
        setX(new Long(Math.round(getX() + Math.cos(this.angle * Math.PI / 180))).intValue());
        setY(new Long(Math.round(getY() + Math.sin(this.angle * Math.PI / 180))).intValue());

        if(getX() <= 0 || getX() >= board.getWidth() - sprite.getWidth()) {
            changeAngle();
            interact.notify(this, EventType.SCORE);
        }

        if(getY() <= 0 || getY() >= board.getHeight() - sprite.getHeight()) { // 270 -> 90  269 -> 91
            angle = 360 - angle;
            interact.notify(this, EventType.WALL_INTERACT);
        }
    }

    public Eventable getInteract() {
        return interact;
    }

    public void interact(List<Movable> movables) {
        for(Movable movable : movables) {
            if(!(getX() + getWidth() < movable.getX() || movable.getX() + movable.getWidth() < getX() ||
                    getY() + getHeight() < movable.getY() || movable.getY() + movable.getHeight() < getY())) {
                changeAngle();
                move();
                interact.notify(this, EventType.OBJ_INTERACT);
            }
        }
    }
}
