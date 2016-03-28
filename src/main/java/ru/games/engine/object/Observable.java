package ru.games.engine.object;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Crow on 28.03.2016.
 */
public class Observable {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notify(GameObject gameObject, GameEvent event) {
        for(Observer observer : observers) {
            observer.notify(gameObject, event);
        }
    }
}
