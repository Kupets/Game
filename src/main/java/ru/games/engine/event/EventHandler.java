package ru.games.engine.event;

import ru.games.engine.model.ObjectOnBoard;

/**
 * Created by Crow on 28.03.2016.
 */
public interface EventHandler {
    void notify(ObjectOnBoard objectOnBoard, EventType event);
}
