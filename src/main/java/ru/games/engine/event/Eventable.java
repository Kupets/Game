package ru.games.engine.event;

import ru.games.engine.model.ObjectOnBoard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Crow on 28.03.2016.
 */
public class Eventable {
    private List<EventHandler> eventHandlers = new ArrayList<EventHandler>();

    public void addHandler(EventHandler o) {
        eventHandlers.add(o);
    }

    public void removeHandler(EventHandler o) {
        eventHandlers.remove(o);
    }

    public void notify(ObjectOnBoard objectOnBoard, EventType event) {
        for(EventHandler eventHandler : eventHandlers) {
            eventHandler.notify(objectOnBoard, event);
        }
    }
}
