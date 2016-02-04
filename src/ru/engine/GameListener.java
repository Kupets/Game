package ru.engine;

/**
 * Created by Crow on 03.02.2016.
 */
public interface GameListener {
    void start();   // вызывается, когда игра началась
    void update();  // вызывается каждый фрейм
    void draw();    // аналогично update()
    void destroy(); // вызывается, когда объект "отключается"
}
