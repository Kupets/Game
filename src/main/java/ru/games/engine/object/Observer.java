package ru.games.engine.object;

/**
 * Created by Crow on 28.03.2016.
 */
public interface Observer {
    void notify(GameObject gameObject, GameEvent event);
}
