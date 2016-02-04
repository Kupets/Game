package ru.engine;

import java.util.ArrayList;

/**
 * Created by Crow on 03.02.2016.
 */
public abstract class Scene implements GameListener {

    ArrayList<GameListener> gameListeners = new ArrayList<GameListener>();

    public abstract void initializeScene();

    public final void AddToScene(GameListener gameListener) {
        gameListeners.add(gameListener);
    }

    public final void onInitializeScene() {
        if (gameListeners.isEmpty())
            initializeScene();
    }

    @Override
    public final void start() {
        for (GameListener gameListener : gameListeners)
            gameListener.start();
    }

    @Override
    public final void update() {
        for (GameListener gameListener : gameListeners)
            gameListener.update();
    }

    @Override
    public final void draw() {
        for (GameListener gameListener : gameListeners)
            gameListener.draw();
    }

    public final void onDestroy() {
        for (GameListener gameListener : gameListeners)
            gameListener.destroy();

        gameListeners.clear();
    }

    @Override
    public final void destroy() {}
}
