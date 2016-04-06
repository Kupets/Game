package ru.games.engine.model;

import ru.games.engine.object.Board;
import ru.games.engine.event.EventType;
import ru.games.engine.event.Eventable;

import java.util.Random;

/**
 * Created by Crow on 09.02.2016.
 */
public class Ball extends Movable {
    private Eventable interact = new Eventable();
    private int angle;


    public Ball(Board board) {
        super("/ball.png", board);
    }

    @Override
    public void init() {
        super.init();

        setX(board.getWidth() / 2);
        setY(board.getHeight() / 2);

        if(new Random().nextBoolean()) {
            angle = 360;
        } else {
            angle = 180;
        }
    }

    @Override
    protected void move() {
        setX(new Long(Math.round(getX() + Math.cos(this.angle * Math.PI / 180))).intValue());
        setY(new Long(Math.round(getY() + Math.sin(this.angle * Math.PI / 180))).intValue());

        if(getX() <= 0 || getX() >= board.getWidth() - sprite.getWidth()) {
            interact.notify(this, EventType.OBJ_INTERACT);
            if(angle == 180 || angle == 360 || angle == 0) {
                angle = new Random().nextBoolean() ? 360 - Math.abs(angle - 135) : Math.abs(angle - 135);
                DEFAULT_MOVE_SPEED_MODULO_IN_MILLIS *= 1.5;
            } else {
                angle = 180 - angle;
                if(angle < 0)
                    angle += 360;
            }
        }

        if(getY() <= 0 || getY() >= board.getHeight() - sprite.getHeight()) { // 270 -> 90  269 -> 91
            interact.notify(this, EventType.WALL_INTERACT);
            angle = 360 - angle;
        }
    }

    public Eventable getInteract() {
        return interact;
    }
}
